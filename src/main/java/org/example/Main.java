package org.example;

import java.util.concurrent.SubmissionPublisher;

import static java.lang.Thread.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Observador observerCeu = new Observador("OBS-CEU");
        Observador observerAgua = new Observador("OBS-AGUA");
        Observador observerTerra = new Observador("OBS-TERRA");

        SubmissionPublisher<String> publisherCeu = new SubmissionPublisher<>();
        SubmissionPublisher<String> publisherAgua = new SubmissionPublisher<>();
        SubmissionPublisher<String> publisherTerra = new SubmissionPublisher<>();

        publisherCeu.subscribe(observerCeu);
        publisherAgua.subscribe(observerAgua);
        publisherTerra.subscribe(observerTerra);

        roundOne(publisherCeu, publisherAgua, publisherTerra);
        roundTwo(publisherCeu, publisherAgua, publisherTerra);

        sleep(100);
    }

    private static void roundOne(
            SubmissionPublisher pCeu,
            SubmissionPublisher pAgua,
            SubmissionPublisher pTerra) throws InterruptedException {
        pCeu.submit("O eclipse lunar iniciou");
        pAgua.submit("Encontramos uma alga rara");
        pTerra.submit("Nada a revelar");
        sleep(1000);
    }

    private static void roundTwo(
            SubmissionPublisher pCeu,
            SubmissionPublisher pAgua,
            SubmissionPublisher pTerra)
    {
        pCeu.submit("O eclipse lunar terminou");
        pAgua.submit("Nada a revelar");
        pTerra.submit("Encontramos o Wally");
    }
}