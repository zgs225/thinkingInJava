package containers;

import utils.PrintUtil;

import java.util.List;

/**
 * Created by yuez on 14-1-15.
 * Applies Test objects to lists of different containers
 */
public class Tester<C> {
    public static int fieldWidth = 0;
    public static TestParam[] defaultParams = TestParam.array(100, 200, 5000, 300, 2340, 10000, 400);

    protected C initialize(int size) {
        return container;
    }

    protected C container;
    private String headline = "";
    private List<Test<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" + 5 + "s";
    private TestParam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null)
            headline = container.getClass().getSimpleName();
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] testParams) {
        this(container, tests);
        this.paramList = testParams;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public static <C> void run(C cntnr, List<Test<C>> tests) {
        new Tester<C>(cntnr, tests).timedTest();
    }

    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<C>(cntnr, tests, paramList);
    }

    public void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder header = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++)
            header.append('-');
        header.append(' ').append(headline).append(' ');
        for (int i = 0; i < dashLength / 2; i++)
            header.append('-');
        PrintUtil.print(header);
        System.out.format(sizeField, "size");
        for (Test test : tests)
            System.out.format(stringField(), test.name);
        PrintUtil.print();
    }

    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                int reps = test.test(kontainer, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            PrintUtil.print();
        }
    }
}
