package io.cloudslang.lang.compiler.validator;

import io.cloudslang.lang.entities.bindings.InOutParam;
import io.cloudslang.lang.entities.bindings.Output;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * User: bancl
 * Date: 6/17/2016
 */
public class AbstractValidator {
    public static final String NAME_PLACEHOLDER = "name_placeholder01";

    protected void validateListsHaveMutuallyExclusiveNames(List<? extends InOutParam> inOutParams, List<Output> outputs, String errorMessage) {
        for (InOutParam inOutParam : CollectionUtils.emptyIfNull(inOutParams)) {
            for (Output output : CollectionUtils.emptyIfNull(outputs)) {
                if (StringUtils.equalsIgnoreCase(inOutParam.getName(), output.getName())) {
                    throw new IllegalArgumentException(errorMessage.replace(NAME_PLACEHOLDER, inOutParam.getName()));
                }
            }
        }
    }
}
