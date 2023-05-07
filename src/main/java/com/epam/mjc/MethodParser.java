package com.epam.mjc;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {

        List<MethodSignature.Argument> MyListArg = new ArrayList<>();
        var SplitList = signatureString.split("\\(",2);
        var PartOne = SplitList[0].split(" ");
        var PartTwo = SplitList[1].split("[ ,+)]");
        for (int i = 0; i < PartTwo.length-1; i= i +3 ){
            MyListArg.add(new MethodSignature.Argument(PartTwo[i],PartTwo[i+1]));
        }

        MethodSignature methodSignature = new MethodSignature(signatureString,MyListArg);

      byte CurrentPozInSplitList = 0;

      if (PartOne.length == 3){
          methodSignature.setAccessModifier(PartOne[CurrentPozInSplitList++]);
      }
      methodSignature.setReturnType(PartOne[CurrentPozInSplitList++]);
      methodSignature.setMethodName(PartOne[CurrentPozInSplitList]);

    return  methodSignature;
    }
}
