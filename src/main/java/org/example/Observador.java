package org.example;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.Flow;

@Log4j2
public class Observador implements Flow.Subscriber<String>{

    private Flow.Subscription subscription;
    private final String subscriptionName;

    public Observador(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(String event) {
        System.out.println(subscriptionName + ": " + event  );
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("There is an error {}", throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Video has ended");
    }
}
