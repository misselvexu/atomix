/*
 * Copyright 2015 the original author or authors.
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
package io.atomix.protocols.raft.storage.log.entry;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Base class for timestamped entries.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public abstract class TimestampedEntry<T extends TimestampedEntry<T>> extends Entry<T> {
  protected final long timestamp;

  protected TimestampedEntry(long timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Returns the entry timestamp.
   *
   * @return The entry timestamp.
   */
  public long timestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return toStringHelper(this)
        .add("timestamp", timestamp)
        .toString();
  }

  /**
   * Timestamped entry serializer.
   */
  public interface Serializer<T extends TimestampedEntry> extends Entry.Serializer<T> {
  }
}