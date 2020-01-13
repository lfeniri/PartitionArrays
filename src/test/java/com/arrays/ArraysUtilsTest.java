package com.arrays;

import com.arrays.exception.PartitionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysUtilsTest {

    @Before
    public void setUp() {
    }

    @Test(expected = PartitionException.class)
    public void partition_array_null() throws PartitionException {
        ArraysUtils.partition(null, 5);
    }
    @Test(expected = PartitionException.class)
    public void partition_negatif_partitionSize() throws PartitionException {
        ArraysUtils.partition(new ArrayList<>(), -2);
    }

    /**
     * This is Exception message Test without librarys
     */
    @Test
    public void partition_0_partitionSize() {
        try {
            ArraysUtils.partition(new ArrayList<>(), -2);
            Assert.fail();
        }catch (PartitionException ex){
            Assert.assertEquals("The partitions size need to be a positive integer",ex.getMessage());
        }
    }

    @Test()
    public void partition_empty_array() throws PartitionException {
        Assert.assertTrue(ArraysUtils.partition(new ArrayList<>(), 5).isEmpty());
    }

    @Test()
    public void partition_pair_size() throws PartitionException {
        int partitionSize = 2;
        List<List<Integer>> partition = ArraysUtils.partition(Arrays.asList(1, 2, 3, 4, 5), partitionSize);
        Assert.assertEquals(3,partition.size());
        Assert.assertEquals(partitionSize,partition.get(0).size());
    }
    @Test()
    public void partition_impair_size() throws PartitionException {
        int partitionSize = 3;
        List<List<Integer>> partition = ArraysUtils.partition(Arrays.asList(1, 2, 3, 4, 5), partitionSize);
        Assert.assertEquals(2,partition.size());
        Assert.assertEquals(partitionSize,partition.get(0).size());
    }
}