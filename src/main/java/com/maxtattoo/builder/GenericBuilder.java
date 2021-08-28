package com.maxtattoo.builder;

import java.util.List;

interface GenericBuilder {

    <INPUT, OUTPUT> OUTPUT buildModel(INPUT input, Class<OUTPUT> output);
    <INPUT, OUTPUT> List<OUTPUT> buildModel(List<INPUT> input, Class<OUTPUT> output);

}
