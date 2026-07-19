package module.three.lld.patterns.structural;

/**
 * Facade provides a simplified, unified interface to a complex subsystem.
 * It makes the subsystems easier to use by hiding its complexity.
 * One simple interface that internally delegates to many complex objects.
 * <p>
 * What makes this a Facade pattern:
 * - Multiple subsystem classes exist
 * - Client does not interact with them directly
 * - A higher-level API (Computer.start()) coordinates them
 * - Complexity is hidden behind one simplified interface
 * <p>
 * One important distinction:
 * - This is a Facade, not just a wrapper, because it coordinates several subsystem operations into a meaningful workflow.
 */
public class _3Facade {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
    }

}

class CPU {
    void start() {
        System.out.println("CPU started");
    }
}

class Memory {
    void load() {
        System.out.println("Memory loaded");
    }
}

class HardDrive {
    void read() {
        System.out.println("Hard drive read");
    }
}

class Computer {
    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        this.cpu.start();
        this.memory.load();
        this.hardDrive.read();
    }
}
