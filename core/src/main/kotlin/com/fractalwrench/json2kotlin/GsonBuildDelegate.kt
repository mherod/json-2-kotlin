package com.fractalwrench.json2kotlin

import com.google.gson.annotations.SerializedName
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

class GsonBuildDelegate: SourceBuildDelegate {

    override fun prepareClassProperty(propertyBuilder: PropertySpec.Builder,
                                      kotlinIdentifier: String,
                                      jsonKey: String?) {
        if (kotlinIdentifier != jsonKey) {
            val serializedNameBuilder = AnnotationSpec.builder(SerializedName::class)
            serializedNameBuilder.addMember("value=\"$jsonKey\"")
            propertyBuilder.addAnnotation(serializedNameBuilder.build())
        }
    }

    override fun prepareClass(classBuilder: TypeSpec.Builder,
                              kotlinIdentifier: String,
                              jsonElement: TypedJsonElement) {
    }

}