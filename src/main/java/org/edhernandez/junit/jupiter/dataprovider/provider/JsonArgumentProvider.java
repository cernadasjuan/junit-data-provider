/**
 * Copyright 2018-2018 Eduardo Hernandez
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.edhernandez.junit.jupiter.dataprovider.provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.edhernandez.junit.jupiter.dataprovider.annotation.JsonSource;
import org.edhernandez.junit.jupiter.dataprovider.argument.TestArgument;
import org.edhernandez.junit.jupiter.dataprovider.enums.JacksonPropertyNamingStrategy;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Read arguments for Junit5 test from json file
 *
 * @author Eduardo Hernandez
 */
public class JsonArgumentProvider extends ArgumentProvider<JsonSource> {

    @Override
    public void accept(JsonSource jsonSource) {
        values = jsonSource.values();
        type = jsonSource.type();
        objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(getPropertyNamingStrategy(jsonSource.propertyNamingStrategy()))
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }

}
