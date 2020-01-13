package com.arrays;

import com.arrays.exception.PartitionException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ArraysUtils {

    static List<List<Integer>> partition(List<Integer> list, int partitionSize) throws PartitionException {

        if(list == null){
            throw new PartitionException("Can't partition null list");
        }
        if(partitionSize <= 0){
            throw new PartitionException("The partitions size need to be a positive integer");
        }
        AtomicInteger index = new AtomicInteger();
        return new ArrayList<>(list.stream().collect(Collectors.groupingBy(elem -> index.getAndIncrement() / partitionSize)).values());
    }
}