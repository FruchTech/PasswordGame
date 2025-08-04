package model.rules;

public interface IRule {

    String requirement();

    String shortRequirement();

    boolean validate(String password);
}
