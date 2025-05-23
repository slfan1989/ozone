/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.ozone.container.common.volume;

import org.apache.hadoop.metrics2.MetricsSystem;
import org.apache.hadoop.metrics2.annotation.Metric;
import org.apache.hadoop.metrics2.lib.DefaultMetricsSystem;
import org.apache.hadoop.metrics2.lib.MetricsRegistry;
import org.apache.hadoop.metrics2.lib.MutableCounterLong;
import org.apache.hadoop.metrics2.lib.MutableQuantiles;
import org.apache.hadoop.metrics2.lib.MutableRate;

/**
 * This class is used to track Volume IO stats for each HDDS Volume.
 */
public class VolumeIOStats {
  private String metricsSourceName = VolumeIOStats.class.getSimpleName();
  private String storageDirectory;
  private final MetricsRegistry registry = new MetricsRegistry("VolumeIOStats");
  @Metric
  private MutableCounterLong readBytes;
  @Metric
  private MutableCounterLong readOpCount;
  @Metric
  private MutableCounterLong writeBytes;
  @Metric
  private MutableCounterLong writeOpCount;
  @Metric
  private MutableRate readTime;
  @Metric
  private MutableQuantiles[] readLatencyQuantiles;
  @Metric
  private MutableRate writeTime;
  @Metric
  private MutableQuantiles[] writeLatencyQuantiles;

  @Deprecated
  public VolumeIOStats() {
    init();
  }

  /**
   * @param identifier Typically, path to volume root. e.g. /data/hdds
   */
  public VolumeIOStats(String identifier, String storageDirectory, int[] intervals) {
    this.metricsSourceName += '-' + identifier;
    this.storageDirectory = storageDirectory;

    // Try initializing `readLatencyQuantiles` and `writeLatencyQuantiles`
    if (intervals != null && intervals.length > 0) {
      final int length = intervals.length;
      readLatencyQuantiles = new MutableQuantiles[intervals.length];
      writeLatencyQuantiles = new MutableQuantiles[intervals.length];
      for (int i = 0; i < length; i++) {
        readLatencyQuantiles[i] = registry.newQuantiles(
            "readLatency" + intervals[i] + "s",
            "Read Data File Io Latency in ms", "ops", "latency", intervals[i]);
        writeLatencyQuantiles[i] = registry.newQuantiles(
            "writeLatency" + intervals[i] + "s",
            "Write Data File Io Latency in ms", "ops", "latency", intervals[i]);
      }
    }
    init();
  }

  public void init() {
    MetricsSystem ms = DefaultMetricsSystem.instance();
    ms.register(metricsSourceName, "Volume I/O Statistics", this);
  }

  public void unregister() {
    MetricsSystem ms = DefaultMetricsSystem.instance();
    ms.unregisterSource(metricsSourceName);
  }

  public String getMetricsSourceName() {
    return metricsSourceName;
  }

  /**
   * Increment number of bytes read from the volume.
   * @param bytesRead
   */
  public void incReadBytes(long bytesRead) {
    readBytes.incr(bytesRead);
  }

  /**
   * Increment the read operations performed on the volume.
   */
  public void incReadOpCount() {
    readOpCount.incr();
  }

  /**
   * Increment number of bytes written on to the volume.
   * @param bytesWritten
   */
  public void incWriteBytes(long bytesWritten) {
    writeBytes.incr(bytesWritten);
  }

  /**
   * Increment the write operations performed on the volume.
   */
  public void incWriteOpCount() {
    writeOpCount.incr();
  }

  /**
   * Increment the time taken by read operation on the volume.
   * @param time
   */
  public void incReadTime(long time) {
    readTime.add(time);
    for (MutableQuantiles q : readLatencyQuantiles) {
      q.add(time);
    }
  }

  /**
   * Increment the time taken by write operation on the volume.
   * @param time
   */
  public void incWriteTime(long time) {
    writeTime.add(time);
    for (MutableQuantiles q : writeLatencyQuantiles) {
      q.add(time);
    }
  }

  /**
   * Returns total number of bytes read from the volume.
   * @return long
   */
  public long getReadBytes() {
    return readBytes.value();
  }

  /**
   * Returns total number of bytes written to the volume.
   * @return long
   */
  public long getWriteBytes() {
    return writeBytes.value();
  }

  /**
   * Returns total number of read operations performed on the volume.
   * @return long
   */
  public long getReadOpCount() {
    return readOpCount.value();
  }

  /**
   * Returns total number of write operations performed on the volume.
   * @return long
   */
  public long getWriteOpCount() {
    return writeOpCount.value();
  }

  /**
   * Returns total read operations time on the volume.
   * @return long
   */
  public long getReadTime() {
    return (long) readTime.lastStat().total();
  }

  /**
   * Returns total write operations time on the volume.
   * @return long
   */
  public long getWriteTime() {
    return (long) writeTime.lastStat().total();
  }

  @Metric
  public String getStorageDirectory() {
    return storageDirectory;
  }
}
