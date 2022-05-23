package com.javiersc.gradle.huble.options

import javax.inject.Inject
import org.gradle.api.model.ObjectFactory

public abstract class Options
@Inject
constructor(
    objects: ObjectFactory,
) : ObjectFactory by objects
