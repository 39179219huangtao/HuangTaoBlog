//package com.hyc.shop;
//
///**
// * @program: demo
// * @description: grpc
// * @author: zuochangqin
// * @create: 2019-04-03 11:19
// **/
//
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import hello.HelloServiceGrpc;
//import hello.Hello.HelloRequest;
//import hello.Hello;
//import io.grpc.stub.StreamObserver;
//
//import java.io.IOException;
//
//public class HelloWorldServer {
//
//
//	private int port = 9999;
//	private Server server;
//
//	private void start() throws IOException {
//		server = ServerBuilder.forPort(port)
//				.addService(new GreeterImpl())
//				.build()
//				.start();
//
//		System.out.println("service start...");
//
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//
//			@Override
//			public void run() {
//
//				System.err.println("*** shutting down gRPC server since JVM is shutting down");
//				HelloWorldServer.this.stop();
//				System.err.println("*** server shut down");
//			}
//		});
//	}
//
//	private void stop() {
//		if (server != null) {
//			server.shutdown();
//		}
//	}
//
//	// block 一直到退出程序
//	private void blockUntilShutdown() throws InterruptedException {
//		if (server != null) {
//			server.awaitTermination();
//		}
//	}
//
//
//	public static void main(String[] args) throws IOException, InterruptedException {
//
//		final HelloWorldServer server = new HelloWorldServer();
//		server.start();
//		server.blockUntilShutdown();
//	}
//
//
//	// 实现 定义一个实现服务接口的类
//	private class GreeterImpl extends HelloServiceGrpc.HelloServiceImplBase {
//
//
//		@Override
//		public void sayHello(HelloRequest req, StreamObserver<Hello.HelloResponse> responseObserver) {
//			System.out.println("service:" + req.getGreeting());
//			Hello.HelloResponse reply = Hello.HelloResponse.newBuilder().setReply(("Hello: " + req.getGreeting())).build();
//			responseObserver.onNext(reply);
//			responseObserver.onCompleted();
//		}
//	}
//}
