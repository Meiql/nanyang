package org.springrain.erp.gz.util;

import java.util.Map;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;

public class RoundFunction  extends AbstractFunction{
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Number v1 = FunctionUtils.getNumberValue(arg1, env);
        Number v2 = FunctionUtils.getNumberValue(arg2, env);
        String v=MathUtils.formatNumber(v1.toString(), v2.intValue());
        return new AviatorString(v);
    }
    public String getName() {
        return "round";
    }
}
