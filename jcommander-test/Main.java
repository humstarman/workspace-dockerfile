package com.my.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.JCommander;

class Main {
    @Parameter(names={"--length", "-l"})
    int length;
    @Parameter(names={"--pattern", "-p"})
    int pattern;

    public static void main(String ... argv) {
        Main main = new Main();
        JCommander.newBuilder()
            .addObject(main)
            .build()
            .parse(argv);
        main.run();
    }

    public void run() {
        System.out.printf("%d %d", length, pattern);
    }
}
