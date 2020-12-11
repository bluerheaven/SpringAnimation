package com.mbelec.plugin;

import org.gradle.api.Plugin
import org.gradle.api.Project;

public class HenCoder implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def extension = target.extensions.create('hencoder', HenCoderExtension)
        target.afterEvaluate {
            println "Hello ${extension.name}!"
        }
    }
}