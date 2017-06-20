/*
 * Copyright 2015-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.storage;

/**
 * Storage level configuration values which control how logs are stored on disk or in memory.
 */
public enum StorageLevel {

  /**
   * Stores logs in memory only.
   * <p>
   * In-memory logs will be written to buffers backed by {@link io.atomix.buffer.HeapBuffer}.
   * Each {@code MEMORY} segment may only store up to {@code 2^32-1} bytes. <em>Entries written to in-memory logs are
   * not recoverable after a crash.</em> If your use case requires strong persistence, use {@link #DISK} or {@link #MAPPED}
   * storage.
   */
  MEMORY,

  /**
   * Stores logs in memory mapped files.
   * <p>
   * Memory mapped logs will be written to buffers backed by {@link io.atomix.buffer.MappedBuffer}.
   * Entries written to memory mapped files may be recovered after a crash, but the {@code MAPPED} storage level does not
   * guarantee that <em>all</em> entries written to the log will be persisted. Additionally, the use of persistent storage
   * levels reduces the amount of overhead required to catch the log up at startup.
   */
  MAPPED,

  /**
   * Stores logs on disk.
   * <p>
   * On-disk logs will be written to buffers backed by {@link io.atomix.buffer.FileBuffer}, which
   * in turn is backed by {@link java.io.RandomAccessFile}. Entries written to {@code DISK} storage can be recovered in the
   * event of a failure or other restart. Additionally, the use of persistent storage levels reduces the amount of overhead
   * required to catch the log up at startup.
   */
  DISK

}