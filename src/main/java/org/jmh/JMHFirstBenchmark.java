package org.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author hy_gu on 2018/11/28
 **/
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
// @State(Scope.Thread)
public class JMHFirstBenchmark {
  static int millis = 24 * 3600 * 1000;

  public static void main(String[] args) throws Exception {
    Options options = new OptionsBuilder().include(JMHFirstBenchmark.class.getName()).forks(1).build();
    new Runner(options).run();
  }

  @Benchmark
  @Threads(5)
  public void runCalendar() {
    Calendar calendar = Calendar.getInstance();
  }

  @Benchmark
  @Threads(5)
  public void runDate(){
    Date date=new Date();
  }

  @Benchmark
  @Threads(5)
  public void runSystem() {
    long result = System.currentTimeMillis() / millis;
  }
}
