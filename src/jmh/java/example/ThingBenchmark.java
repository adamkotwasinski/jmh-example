package example;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * @author adam.kotwasinski
 */
@BenchmarkMode({ Mode.AverageTime, Mode.Throughput })
// Just some minimal values.
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 10, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class ThingBenchmark {

    private int arg1 = 13;
    private int arg2 = 42424242;
    private int arg3 = 0xFFFFFFFF;

    @Benchmark
    public int myBenchmark1() {
        return Thing.compute(this.arg1);
    }

    @Benchmark
    public int myBenchmark2() {
        return Thing.compute(this.arg2);
    }

    @Benchmark
    public int myBenchmark3() {
        return Thing.compute(this.arg3);
    }

}
