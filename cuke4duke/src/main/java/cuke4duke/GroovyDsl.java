package cuke4duke;

import groovy.lang.Closure;
import java.util.regex.Pattern;
import java.util.List;

import cuke4duke.internal.groovy.GroovyStepDefinition;
import cuke4duke.internal.groovy.GroovyHook;
import cuke4duke.internal.groovy.GroovyLanguage;
import cuke4duke.internal.language.StepMother;

/**
 * The DSL for Groovy step definitions.
 */
public class GroovyDsl {
    public static StepMother stepMother;
    public static GroovyLanguage groovyLanguage;

    public static void Before(List<String> tagNames, Closure body) {
        stepMother.register_hook("before", new GroovyHook(tagNames, body, groovyLanguage));
    }

    public static void After(List<String> tagNames, Closure body) {
        stepMother.register_hook("after", new GroovyHook(tagNames, body, groovyLanguage));
    }

    public static void Given(Pattern pattern, Closure body) {
        registerStepDefinition(pattern, body);
    }

    public static void When(Pattern pattern, Closure body) {
        registerStepDefinition(pattern, body);
    }

    public static void Then(Pattern pattern, Closure body) {
        registerStepDefinition(pattern, body);
    }

    private static void registerStepDefinition(Pattern pattern, Closure body) {
        stepMother.register_step_definition(new GroovyStepDefinition(groovyLanguage, pattern, body));
    }
}