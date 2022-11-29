package br.com.cardoso.greeting.extension.deployment;

import br.com.cardoso.greeting.extension.runtime.GreetingExtensionServlet;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.undertow.deployment.ServletBuildItem;

class GreetingExtensionProcessor {

    private static final String FEATURE = "greeting-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    ServletBuildItem createServlet() {
        return ServletBuildItem.builder(FEATURE, GreetingExtensionServlet.class.getName())
                .addMapping("/greeting")
                .build();
    }
}
