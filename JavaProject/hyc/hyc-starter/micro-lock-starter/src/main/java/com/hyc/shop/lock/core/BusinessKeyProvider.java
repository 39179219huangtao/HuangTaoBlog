package com.hyc.shop.lock.core;

import com.hyc.shop.lock.annotation.MicroLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: 获取用户定义业务key
 * @author: huangtao
 * @date: 2019/6/12
 */
public class BusinessKeyProvider {

    private ParameterNameDiscoverer nameDiscoverer = new DefaultParameterNameDiscoverer();

    private ExpressionParser parser = new SpelExpressionParser();

    public String getKeyName(ProceedingJoinPoint joinPoint, MicroLock microLock) {
        List<String> keyList = new ArrayList<>();
        Method method = getMethod(joinPoint);
        List<String> definitionKeys = getSpelDefinitionKey(microLock.keys(), method, joinPoint.getArgs());
        keyList.addAll(definitionKeys);

        return StringUtils.collectionToDelimitedString(keyList,"","-","");
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method.getDeclaringClass().isInterface()) {
            try {
                method = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(),
                        method.getParameterTypes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return method;
    }

    private List<String> getSpelDefinitionKey(String[] definitionKeys, Method method, Object[] parameterValues) {
        List<String> definitionKeyList = new ArrayList<>();
        for (String definitionKey : definitionKeys) {
            if (definitionKey != null && !definitionKey.isEmpty()) {
                EvaluationContext context = new MethodBasedEvaluationContext(null, method, parameterValues, nameDiscoverer);
                String key = parser.parseExpression(definitionKey).getValue(context).toString();
                definitionKeyList.add(key);
            }
        }
        return definitionKeyList;
    }
}
