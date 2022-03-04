package ru.learnup;

public class Calculator {
    private final SumProcessor sumProcessor;
    private final SubtractProcessor subtractProcessor;
    private final DivideProcessor divideProcessor;
    private final MultiplyProcessor multiplyProcessor;

    public Calculator(SumProcessor sumProcessor, SubtractProcessor subtractProcessor, DivideProcessor divideProcessor, MultiplyProcessor multiplyProcessor) {
        this.sumProcessor = sumProcessor;
        this.subtractProcessor = subtractProcessor;
        this.divideProcessor = divideProcessor;
        this.multiplyProcessor = multiplyProcessor;
    }

    public Double sum(Double arg1, Double arg2) {
        return sumProcessor.process(arg1, arg2);
    }

    public Double subtract(Double arg1, Double arg2) {
        return subtractProcessor.process(arg1, arg2);
    }

    public Double divide(Double arg1, Double arg2) {
        return divideProcessor.process(arg1, arg2);
    }

    public Double multiply(Double arg1, Double arg2) {
        return multiplyProcessor.process(arg1, arg2);
    }
}
