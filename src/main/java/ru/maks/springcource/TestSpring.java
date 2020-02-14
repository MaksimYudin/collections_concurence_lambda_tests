package ru.maks.springcource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSpring {


    public static void main(String[] args) throws InterruptedException {
//        Worker worker = new Worker();
//        worker.main();

//        ProducerConsumer producerConsumer = new ProducerConsumer();
//        producerConsumer.doProducerConsumer();

//        WaitNotify wn = new WaitNotify();
//        wn.doWaitNotify();

//        MyCountDownLatch myCountDownLatch = new MyCountDownLatch();
//        myCountDownLatch.doMyCountDownLatch();

//        MyReentrantLock myReentrantLock = new MyReentrantLock();
//        myReentrantLock.doReentrantLock();

//        MySimaphor mySimaphor = new MySimaphor();
//        mySimaphor.doMySymaphore();

//        DeathLockExample deathLockExample = new DeathLockExample();
//        deathLockExample.doWork();

//        MyInterruptedException myInterruptedException = new MyInterruptedException();
//        myInterruptedException.doNyInterruptedException();

//        MyCollableAndFuture myCollableAndFuture = new MyCollableAndFuture();
//        myCollableAndFuture.doWork();

        RegExpExample regExpExample = new RegExpExample();
        regExpExample.doWork();

    }

    public static void doMeasure(List<Integer> list) {

        long start = System.currentTimeMillis();

            for (int i = 0; i < 100000; i++)
                list.add(0, i);
//            for (int i = 0; i < 100000; i++)
//                list.get(i);

            long end = System.currentTimeMillis();

            System.out.println(end - start);
    }

    public static void testMap(Map<Integer, String> myMap) {
        myMap.put(4, "aaa");
        myMap.put(8, "fff");
        myMap.put(12, "rrr");
        myMap.put(2, "ddds");
        myMap.put(93, "rre");
        myMap.put(3, "dsq");
        myMap.put(1, "dsq");

        for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void addData(Collection<Person> myCollection) {
        myCollection.add(new Person(2, "maks"));
        myCollection.add(new Person(1, "sonya"));
        myCollection.add(new Person(3, "lena"));
    }

    public static void test1() {
        MyThread myThread1 = new MyThread();
        myThread1.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread1.shutdown();

//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        //queue.add(3);
//
//        queue.remove();
//        queue.remove();
//        queue.remove();
//        queue.element();

//        List<Person> personList = new ArrayList<>();
//        Set<Person> personSet = new TreeSet<>();
//
//        addData(personList);
//        addData(personSet);
//
//        //Collections.sort(personList);
//
//        System.out.println(personList);
//        System.out.println(personSet);


        //        List<String> list = new ArrayList<>();
//        list.add("Annyn");
//        list.add("Kate");
//        list.add("Bo");
//        list.add("Ply");
//
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                if (s.length() > t1.length()) {
//                    return -1;
//                } else if (s.length() < t1.length()) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//        });
//        System.out.println(list);



//        Set<Person> hashSet = new HashSet<>();
//
//        Person person1 = new Person(2, "Kate");
//        Person person2 = new Person(2, "Kate");
//
//        hashSet.add(person1);
//        hashSet.add(person2);
//
//        System.out.println(hashSet);


//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.add(1);
//        myLinkedList.add(2);
//        myLinkedList.add(3);
//        myLinkedList.showMyLinkedList();
//
//        myLinkedList.remove(0);
//        myLinkedList.showMyLinkedList();
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//
//        List<Integer> linkedList = new LinkedList<>();
//        List<Integer> arrayList = new ArrayList<>();
//
//        doMeasure(linkedList);
//        doMeasure(arrayList);


//        Music rockMusic = context.getBean("rockMusic", Music.class);
//        Music classicalMusic = context.getBean("classicalMusic", Music.class);

//        MusicPlayer rockMP = new MusicPlayer(rockMusic);
//        MusicPlayer classicalMP = new MusicPlayer(classicalMusic);
//
//        rockMP.playMusic();
//        classicalMP.playMusic();

//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        System.out.printf(musicPlayer.playMusic());

//        Computer computer = context.getBean("computer", Computer.class);
//        System.out.printf(computer.getSong());

//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        System.out.println(musicPlayer.playMusic());
        //System.out.println(musicPlayer.getName());
        //System.out.println(musicPlayer.getVolume());

        // context.close();
    }

    public static void threadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++)
            executorService.submit(new MyRunner(i));

        executorService.shutdown();
        System.out.println("all submitted");

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class MyThread extends Thread {
    private volatile boolean isActive = true;
    public void run() {
        int i = 0;
        while (isActive){
            System.out.println("MyThread " + i);
            i++;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.isActive = false;
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i =0; i<= 1000; i++) {
            System.out.println("MyThread " + i);
        }
    }
}

class Worker {
    private List<Integer> arrayList1 = new ArrayList<>();
    private List<Integer> arrayList2 = new ArrayList<>();

    Object lock1 = new Object();
    Object lock2 = new Object();

    private void addToList1()  {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList1.add(new Random().nextInt(100));
        }
    }

    private void addToList2()  {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList2.add(new Random().nextInt(100));
        }
    }

    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {

        long start = System.currentTimeMillis();

        //work();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Miliseconds: " + (end - start));
        System.out.println(arrayList1.size());
        System.out.println(arrayList2.size());

    }

}

class MyRunner implements Runnable {
    private int index;

    public MyRunner(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("running " + index);
    }
}

class ProducerConsumer {
    private BlockingQueue<Integer> myQueue = new ArrayBlockingQueue<Integer>(10);
    private void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            myQueue.put(random.nextInt(100));
        }
    }

    private void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 5) {
                System.out.println("element: " + myQueue.take());
                System.out.println("size " + myQueue.size());
            }
        }
    }

    public void doProducerConsumer() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class WaitNotify {
    private void producer() throws InterruptedException {
        synchronized (this) {
            System.out.println("start producer");
            wait();
            System.out.println("end producer");
        }
    }

    private void consumer() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this) {
            System.out.println("consumer start");
            scanner.nextLine();
            notify();
            System.out.println("consumer end");
        }


    }

    public void doWaitNotify() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class MyCountDownLatch {
    public void doMyCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++)
            executorService.submit(new CountDownLatchProcessor(countDownLatch));

        executorService.shutdown();

        try {
            countDownLatch.await();
            System.out.println("latch opened");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CountDownLatchProcessor implements Runnable {
    private CountDownLatch countDownLatch;

    public CountDownLatchProcessor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();
    }
}

class MyReentrantLock {
    Task task = new Task();

    public void doReentrantLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.showNumber();

    }
}

class Task {
    private int number;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            number++;
        }
    }

    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void showNumber() {
        System.out.println(number);
    }
}

class MySimaphor {
    public void doMySymaphore() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        final Connection connection = Connection.getConnection();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

        System.out.println(connection.getConnectionCount());
    }
}

class Connection {
    private static Connection connection = new Connection();
    private int connectionCount;
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {}

    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }
        System.out.println(semaphore.getQueueLength());
    }

    public void doWork() throws InterruptedException {
        synchronized (this) {
            connectionCount++;
            System.out.println("increment " + connectionCount);
        }

        Thread.sleep(3000);
        System.out.println("after sleep");

        synchronized (this) {
            connectionCount--;
            System.out.println("decrement " + connectionCount);
        }
    }

    public int getConnectionCount() {
        return connectionCount;
    }
}

class DeathLockExample {

    public void doWork() {
        final RunnerDeathLock runnerDeathLock = new RunnerDeathLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runnerDeathLock.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runnerDeathLock.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runnerDeathLock.finished();
    }
}

class RunnerDeathLock {
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void takeLocks() {
        boolean firstLocked = false;
        boolean secondLocked = false;

        while (true) {
            try {
                firstLocked = lock1.tryLock();
                secondLocked = lock2.tryLock();

            } finally {
                if (firstLocked && secondLocked)
                    return;

                if (firstLocked)
                    lock1.unlock();

                if (secondLocked)
                    lock2.unlock();
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks();
            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks();
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total: " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
    private int balance = 10000;

    public void deposite(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account account1, Account account2, int amount) {
        account1.withdraw(amount);
        account2.deposite(amount);
    }
}

class MyInterruptedException {
    public void doNyInterruptedException() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("interrupted");
                        break;
                    }

                    System.out.println(Math.sin(random.nextDouble()));
                }
            }
        });

        System.out.println("start");
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join();

        System.out.println("end");

    }
}

class MyCollableAndFuture {
    private static int result;
    public void doWork() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int value = new Random().nextInt(10);
                if (value < 5)
                    throw new Exception("Не верное число");

                Random random = new Random();
                return random.nextInt(1000);
            }
        });

        executorService.shutdown();
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }

        System.out.println(result);
    }
}


