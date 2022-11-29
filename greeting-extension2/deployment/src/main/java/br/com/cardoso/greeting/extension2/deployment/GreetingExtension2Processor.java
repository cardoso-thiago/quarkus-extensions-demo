package br.com.cardoso.greeting.extension2.deployment;

import br.com.cardoso.greeting.extension2.runtime.GreetingExtensionServlet2;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.undertow.deployment.ServletBuildItem;

class GreetingExtension2Processor {

    private static final String FEATURE = "greeting-extension2";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    ServletBuildItem createServlet() {
        return ServletBuildItem.builder(FEATURE, GreetingExtensionServlet2.class.getName())
                .addMapping("/greeting2")
                .build();
    }
}
