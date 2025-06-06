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

package org.apache.hadoop.ozone;

import java.util.concurrent.TimeUnit;
import org.apache.hadoop.hdds.annotation.InterfaceAudience;
import org.apache.hadoop.hdds.annotation.InterfaceStability;
import org.apache.hadoop.hdds.client.ReplicationFactor;
import org.apache.hadoop.hdds.client.ReplicationType;
import org.apache.hadoop.hdds.scm.ScmConfigKeys;
import org.apache.hadoop.http.HttpConfig;
import org.apache.ratis.util.TimeDuration;

/**
 * This class contains constants for configuration keys used in Ozone.
 */
@InterfaceAudience.Public
@InterfaceStability.Unstable
public final class OzoneConfigKeys {
  public static final String HDDS_CONTAINER_IPC_PORT =
      "hdds.container.ipc.port";
  public static final int HDDS_CONTAINER_IPC_PORT_DEFAULT = 9859;

  public static final String OZONE_METADATA_DIRS = "ozone.metadata.dirs";

  public static final String OZONE_METADATA_DIRS_PERMISSIONS =
      "ozone.metadata.dirs.permissions";
  public static final String OZONE_OM_DB_DIRS_PERMISSIONS =
      "ozone.om.db.dirs.permissions";

  public static final String OZONE_OM_DB_DIRS = "ozone.om.db.dirs";

  /**
   *
   * When set to true, allocate a random free port for ozone container,
   * so that a mini cluster is able to launch multiple containers on a node.
   *
   * When set to false (default), the container port will be specified as
   * {@link #HDDS_CONTAINER_IPC_PORT} and the default value will be specified
   * as {@link #HDDS_CONTAINER_IPC_PORT_DEFAULT}.
   */
  public static final String HDDS_CONTAINER_IPC_RANDOM_PORT =
      "hdds.container.ipc.random.port";
  public static final boolean HDDS_CONTAINER_IPC_RANDOM_PORT_DEFAULT =
      false;

  public static final String HDDS_CONTAINER_RATIS_DATASTREAM_RANDOM_PORT =
      "hdds.container.ratis.datastream.random.port";
  public static final boolean
      HDDS_CONTAINER_RATIS_DATASTREAM_RANDOM_PORT_DEFAULT =
      false;

  public static final String HDDS_CONTAINER_CHUNK_WRITE_SYNC_KEY =
      "hdds.container.chunk.write.sync";
  public static final boolean HDDS_CONTAINER_CHUNK_WRITE_SYNC_DEFAULT = false;
  /**
   * Ratis Port where containers listen to.
   */
  public static final String HDDS_CONTAINER_RATIS_IPC_PORT =
      "hdds.container.ratis.ipc.port";
  public static final int HDDS_CONTAINER_RATIS_IPC_PORT_DEFAULT = 9858;
  /**
   * Ratis Port where containers listen to admin requests.
   */
  public static final String HDDS_CONTAINER_RATIS_ADMIN_PORT =
      "hdds.container.ratis.admin.port";
  public static final int HDDS_CONTAINER_RATIS_ADMIN_PORT_DEFAULT = 9857;
  /**
   * Ratis Port where containers listen to server-to-server requests.
   */
  public static final String HDDS_CONTAINER_RATIS_SERVER_PORT =
      "hdds.container.ratis.server.port";
  public static final int HDDS_CONTAINER_RATIS_SERVER_PORT_DEFAULT = 9856;

  /**
   * Ratis Port where containers listen to datastream requests.
   */
  public static final String HDDS_CONTAINER_RATIS_DATASTREAM_ENABLED
      = "hdds.container.ratis.datastream.enabled";
  public static final boolean HDDS_CONTAINER_RATIS_DATASTREAM_ENABLED_DEFAULT
      = false;
  public static final String HDDS_CONTAINER_RATIS_DATASTREAM_PORT
      = "hdds.container.ratis.datastream.port";
  public static final int HDDS_CONTAINER_RATIS_DATASTREAM_PORT_DEFAULT
      = 9855;

  /**
   * Flag to enable ratis streaming on filesystem writes.
   */
  public static final String OZONE_FS_DATASTREAM_ENABLED
      = "ozone.fs.datastream.enabled";
  public static final boolean OZONE_FS_DATASTREAM_ENABLED_DEFAULT
      = false;

  /**
   * A threshold to auto select datastream to write files in OzoneFileSystem.
   */
  public static final String OZONE_FS_DATASTREAM_AUTO_THRESHOLD
      = "ozone.fs.datastream.auto.threshold";
  public static final String OZONE_FS_DATASTREAM_AUTO_THRESHOLD_DEFAULT
      = "4MB";

  /**
   * Flag to allow server-side HBase-related features and enhancements to be enabled.
   */
  public static final String OZONE_HBASE_ENHANCEMENTS_ALLOWED
      = "ozone.hbase.enhancements.allowed";
  public static final boolean OZONE_HBASE_ENHANCEMENTS_ALLOWED_DEFAULT
      = false;

  /**
   * Flag to enable hsync/hflush.
   */
  public static final String OZONE_FS_HSYNC_ENABLED
      = "ozone.fs.hsync.enabled";
  public static final boolean OZONE_FS_HSYNC_ENABLED_DEFAULT
      = false;

  /**
   * hsync lease soft limit.
   */
  public static final String OZONE_OM_LEASE_SOFT_LIMIT
      = "ozone.om.lease.soft.limit";
  public static final String OZONE_OM_LEASE_SOFT_LIMIT_DEFAULT
      = "60s";

  /**
   * When set to true, allocate a random free port for ozone container, so that
   * a mini cluster is able to launch multiple containers on a node.
   */
  public static final String HDDS_CONTAINER_RATIS_IPC_RANDOM_PORT =
      "hdds.container.ratis.ipc.random.port";
  public static final boolean HDDS_CONTAINER_RATIS_IPC_RANDOM_PORT_DEFAULT =
      false;

  public static final String OZONE_METADATA_STORE_ROCKSDB_STATISTICS =
      "ozone.metastore.rocksdb.statistics";

  public static final String  OZONE_METADATA_STORE_ROCKSDB_STATISTICS_DEFAULT =
      "OFF";
  public static final String OZONE_METADATA_STORE_ROCKSDB_STATISTICS_OFF =
      "OFF";

  public static final String OZONE_METADATA_STORE_ROCKSDB_CF_WRITE_BUFFER_SIZE =
      "ozone.metastore.rocksdb.cf.write.buffer.size";
  public static final String
      OZONE_METADATA_STORE_ROCKSDB_CF_WRITE_BUFFER_SIZE_DEFAULT = "128MB";

  public static final String OZONE_UNSAFEBYTEOPERATIONS_ENABLED =
      "ozone.UnsafeByteOperations.enabled";
  public static final boolean OZONE_UNSAFEBYTEOPERATIONS_ENABLED_DEFAULT
      = true;

  public static final String OZONE_CONTAINER_CACHE_SIZE =
      "ozone.container.cache.size";
  public static final int OZONE_CONTAINER_CACHE_DEFAULT = 1024;
  public static final String OZONE_CONTAINER_CACHE_LOCK_STRIPES =
      "ozone.container.cache.lock.stripes";
  public static final int OZONE_CONTAINER_CACHE_LOCK_STRIPES_DEFAULT = 1024;

  public static final String OZONE_SCM_BLOCK_SIZE =
      "ozone.scm.block.size";
  public static final String OZONE_SCM_BLOCK_SIZE_DEFAULT = "256MB";

  public static final String OZONE_CLIENT_MAX_EC_STRIPE_WRITE_RETRIES =
      "ozone.client.max.ec.stripe.write.retries";
  public static final String OZONE_CLIENT_MAX_EC_STRIPE_WRITE_RETRIES_DEFAULT =
      "10";
  public static final String OZONE_CLIENT_EC_GRPC_RETRIES_ENABLED =
      "ozone.client.ec.grpc.retries.enabled";
  public static final boolean OZONE_CLIENT_EC_GRPC_RETRIES_ENABLED_DEFAULT
      = true;
  public static final String OZONE_CLIENT_EC_GRPC_RETRIES_MAX =
      "ozone.client.ec.grpc.retries.max";
  public static final int OZONE_CLIENT_EC_GRPC_RETRIES_MAX_DEFAULT = 3;
  public static final String OZONE_GPRC_METRICS_PERCENTILES_INTERVALS_KEY
      = "ozone.grpc.metrics.percentiles.intervals";

  public static final String OZONE_CLIENT_EC_GRPC_WRITE_TIMEOUT =
      "ozone.client.ec.grpc.write.timeout";
  public static final String OZONE_CLIENT_EC_GRPC_WRITE_TIMEOUT_DEFAULT = "30s";

  /**
   * Ozone administrator users delimited by comma.
   * If not set, only the user who launches an ozone service will be the
   * admin user. This property must be set if ozone services are started by
   * different users. Otherwise the RPC layer will reject calls from
   * other servers which are started by users not in the list.
   * */
  public static final String OZONE_ADMINISTRATORS =
      "ozone.administrators";

  public static final String OZONE_ADMINISTRATORS_GROUPS =
      "ozone.administrators.groups";

  public static final String OZONE_S3_ADMINISTRATORS =
      "ozone.s3.administrators";
  public static final String OZONE_S3_ADMINISTRATORS_GROUPS =
      "ozone.s3.administrators.groups";

  public static final String OZONE_READONLY_ADMINISTRATORS =
      "ozone.readonly.administrators";
  public static final String OZONE_READONLY_ADMINISTRATORS_GROUPS =
      "ozone.readonly.administrators.groups";

  /**
   * Used only for testing purpose. Results in making every user an admin.
   * */
  public static final String OZONE_ADMINISTRATORS_WILDCARD = "*";

  // This defines the overall connection limit for the connection pool used in
  // RestClient.
  public static final String OZONE_REST_CLIENT_HTTP_CONNECTION_MAX =
      "ozone.rest.client.http.connection.max";
  public static final int OZONE_REST_CLIENT_HTTP_CONNECTION_DEFAULT = 100;

  // This defines the connection limit per one HTTP route/host.
  public static final String OZONE_REST_CLIENT_HTTP_CONNECTION_PER_ROUTE_MAX =
      "ozone.rest.client.http.connection.per-route.max";

  public static final int
      OZONE_REST_CLIENT_HTTP_CONNECTION_PER_ROUTE_MAX_DEFAULT = 20;

  public static final String OZONE_CLIENT_SOCKET_TIMEOUT =
      "ozone.client.socket.timeout";
  public static final int OZONE_CLIENT_SOCKET_TIMEOUT_DEFAULT = 5000;
  public static final String OZONE_CLIENT_CONNECTION_TIMEOUT =
      "ozone.client.connection.timeout";
  public static final int OZONE_CLIENT_CONNECTION_TIMEOUT_DEFAULT = 5000;

  public static final String OZONE_REPLICATION = "ozone.replication";
  public static final String OZONE_REPLICATION_DEFAULT =
      ReplicationFactor.THREE.toString();

  public static final String OZONE_REPLICATION_TYPE = "ozone.replication.type";
  public static final String OZONE_REPLICATION_TYPE_DEFAULT =
      ReplicationType.RATIS.toString();

  /**
   * Configuration property to configure the cache size of client list calls.
   */
  public static final String OZONE_CLIENT_LIST_CACHE_SIZE =
      "ozone.client.list.cache";
  public static final int OZONE_CLIENT_LIST_CACHE_SIZE_DEFAULT = 1000;

  /**
   * Configuration properties for Ozone Block Deleting Service.
   */
  public static final String OZONE_BLOCK_DELETING_SERVICE_INTERVAL =
      "ozone.block.deleting.service.interval";
  public static final String OZONE_BLOCK_DELETING_SERVICE_INTERVAL_DEFAULT
      = "60s";

  public static final String OZONE_BLOCK_DELETING_SERVICE_TIMEOUT =
      "ozone.block.deleting.service.timeout";
  public static final String OZONE_BLOCK_DELETING_SERVICE_TIMEOUT_DEFAULT
      = "300s"; // 300s for default

  public static final String OZONE_SNAPSHOT_SST_FILTERING_SERVICE_TIMEOUT =
      "ozone.sst.filtering.service.timeout";
  public static final String
      OZONE_SNAPSHOT_SST_FILTERING_SERVICE_TIMEOUT_DEFAULT = "300s";
      // 300s for default

  public static final String OZONE_SNAPSHOT_DELETING_SERVICE_INTERVAL =
      "ozone.snapshot.deleting.service.interval";
  public static final String
      OZONE_SNAPSHOT_DELETING_SERVICE_INTERVAL_DEFAULT = "30s";

  public static final String OZONE_SNAPSHOT_DELETING_SERVICE_TIMEOUT =
      "ozone.snapshot.deleting.service.timeout";
  public static final String
      OZONE_SNAPSHOT_DELETING_SERVICE_TIMEOUT_DEFAULT = "300s";

  public static final String OZONE_BLOCK_DELETING_SERVICE_WORKERS =
      "ozone.block.deleting.service.workers";
  public static final int OZONE_BLOCK_DELETING_SERVICE_WORKERS_DEFAULT
      = 10;

  /**
   * Configuration properties for Ozone Recovering Container Scrubbing Service.
   */
  public static final String
      OZONE_RECOVERING_CONTAINER_SCRUBBING_SERVICE_TIMEOUT =
      "ozone.recovering.container.scrubbing.service.timeout";

  // 300s for default
  public static final String
      OZONE_RECOVERING_CONTAINER_SCRUBBING_SERVICE_TIMEOUT_DEFAULT = "300s";

  public static final String
      OZONE_RECOVERING_CONTAINER_SCRUBBING_SERVICE_WORKERS =
      "ozone.recovering.container.scrubbing.service.workers";
  public static final int
      OZONE_RECOVERING_CONTAINER_SCRUBBING_SERVICE_WORKERS_DEFAULT = 10;

  public static final String
      OZONE_RECOVERING_CONTAINER_TIMEOUT =
      "ozone.recovering.container.timeout";
  public static final String
      OZONE_RECOVERING_CONTAINER_TIMEOUT_DEFAULT = "20m";

  public static final String OZONE_KEY_PREALLOCATION_BLOCKS_MAX =
      "ozone.key.preallocation.max.blocks";
  public static final int OZONE_KEY_PREALLOCATION_BLOCKS_MAX_DEFAULT
      = 64;
  public static final String HDDS_CONTAINER_RATIS_ENABLED_KEY
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_ENABLED_KEY;
  public static final boolean HDDS_CONTAINER_RATIS_ENABLED_DEFAULT
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_ENABLED_DEFAULT;
  public static final String HDDS_CONTAINER_RATIS_RPC_TYPE_KEY
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_RPC_TYPE_KEY;
  public static final String HDDS_CONTAINER_RATIS_RPC_TYPE_DEFAULT
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_RPC_TYPE_DEFAULT;
  public static final String
      HDDS_CONTAINER_RATIS_NUM_WRITE_CHUNK_THREADS_PER_VOLUME_KEY
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_NUM_WRITE_CHUNK_THREADS_PER_VOLUME;
  public static final int
      HDDS_CONTAINER_RATIS_NUM_WRITE_CHUNK_THREADS_PER_VOLUME_DEFAULT
      = ScmConfigKeys.
      HDDS_CONTAINER_RATIS_NUM_WRITE_CHUNK_THREADS_PER_VOLUME_DEFAULT;
  public static final String HDDS_CONTAINER_RATIS_NUM_CONTAINER_OP_EXECUTORS_KEY
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_NUM_CONTAINER_OP_EXECUTORS_KEY;
  public static final int HDDS_CONTAINER_RATIS_NUM_CONTAINER_OP_EXECUTORS_DEFAULT
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_NUM_CONTAINER_OP_EXECUTORS_DEFAULT;
  public static final String HDDS_CONTAINER_RATIS_SEGMENT_SIZE_KEY
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_SEGMENT_SIZE_KEY;
  public static final String HDDS_CONTAINER_RATIS_SEGMENT_SIZE_DEFAULT
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_SEGMENT_SIZE_DEFAULT;
  public static final String HDDS_CONTAINER_RATIS_SEGMENT_PREALLOCATED_SIZE_KEY
      = ScmConfigKeys.HDDS_CONTAINER_RATIS_SEGMENT_PREALLOCATED_SIZE_KEY;
  public static final String
      HDDS_CONTAINER_RATIS_SEGMENT_PREALLOCATED_SIZE_DEFAULT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_SEGMENT_PREALLOCATED_SIZE_DEFAULT;

  // config settings to enable stateMachineData write timeout
  public static final String
      HDDS_CONTAINER_RATIS_STATEMACHINEDATA_SYNC_TIMEOUT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_STATEMACHINEDATA_SYNC_TIMEOUT;
  public static final TimeDuration
      HDDS_CONTAINER_RATIS_STATEMACHINEDATA_SYNC_TIMEOUT_DEFAULT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_STATEMACHINEDATA_SYNC_TIMEOUT_DEFAULT;

  public static final String HDDS_CONTAINER_RATIS_DATANODE_STORAGE_DIR =
      "hdds.container.ratis.datanode.storage.dir";

  public static final String HDDS_RATIS_SERVER_RETRY_CACHE_TIMEOUT_DURATION_KEY =
      ScmConfigKeys.HDDS_RATIS_SERVER_RETRY_CACHE_TIMEOUT_DURATION_KEY;
  public static final TimeDuration
      HDDS_RATIS_SERVER_RETRY_CACHE_TIMEOUT_DURATION_DEFAULT =
      ScmConfigKeys.HDDS_RATIS_SERVER_RETRY_CACHE_TIMEOUT_DURATION_DEFAULT;
  public static final String
      HDDS_CONTAINER_RATIS_STATEMACHINEDATA_SYNC_RETRIES =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_STATEMACHINEDATA_SYNC_RETRIES;
  public static final String HDDS_CONTAINER_RATIS_LOG_QUEUE_NUM_ELEMENTS =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_QUEUE_NUM_ELEMENTS;
  public static final int HDDS_CONTAINER_RATIS_LOG_QUEUE_NUM_ELEMENTS_DEFAULT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_QUEUE_NUM_ELEMENTS_DEFAULT;
  public static final String HDDS_CONTAINER_RATIS_LOG_QUEUE_BYTE_LIMIT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_QUEUE_BYTE_LIMIT;
  public static final String HDDS_CONTAINER_RATIS_LOG_QUEUE_BYTE_LIMIT_DEFAULT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_QUEUE_BYTE_LIMIT_DEFAULT;
  public static final String
      HDDS_CONTAINER_RATIS_LOG_APPENDER_QUEUE_NUM_ELEMENTS =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_APPENDER_QUEUE_NUM_ELEMENTS;
  public static final int
      HDDS_CONTAINER_RATIS_LOG_APPENDER_QUEUE_NUM_ELEMENTS_DEFAULT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_APPENDER_QUEUE_NUM_ELEMENTS_DEFAULT;
  public static final String HDDS_CONTAINER_RATIS_LOG_APPENDER_QUEUE_BYTE_LIMIT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_APPENDER_QUEUE_BYTE_LIMIT;
  public static final String
      HDDS_CONTAINER_RATIS_LOG_APPENDER_QUEUE_BYTE_LIMIT_DEFAULT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_APPENDER_QUEUE_BYTE_LIMIT_DEFAULT;
  public static final String HDDS_CONTAINER_RATIS_LOG_PURGE_GAP =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_PURGE_GAP;
  public static final int HDDS_CONTAINER_RATIS_LOG_PURGE_GAP_DEFAULT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LOG_PURGE_GAP_DEFAULT;
  public static final String HDDS_CONTAINER_RATIS_LEADER_PENDING_BYTES_LIMIT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LEADER_PENDING_BYTES_LIMIT;
  public static final String
      HDDS_CONTAINER_RATIS_LEADER_PENDING_BYTES_LIMIT_DEFAULT =
      ScmConfigKeys.HDDS_CONTAINER_RATIS_LEADER_PENDING_BYTES_LIMIT_DEFAULT;
  public static final String
      HDDS_RATIS_LEADER_ELECTION_MINIMUM_TIMEOUT_DURATION_KEY =
      ScmConfigKeys.HDDS_RATIS_LEADER_ELECTION_MINIMUM_TIMEOUT_DURATION_KEY;
  public static final TimeDuration
      HDDS_RATIS_LEADER_ELECTION_MINIMUM_TIMEOUT_DURATION_DEFAULT =
      ScmConfigKeys.HDDS_RATIS_LEADER_ELECTION_MINIMUM_TIMEOUT_DURATION_DEFAULT;
  public static final String HDDS_RATIS_SNAPSHOT_THRESHOLD_KEY =
      ScmConfigKeys.HDDS_RATIS_SNAPSHOT_THRESHOLD_KEY;
  public static final long HDDS_RATIS_SNAPSHOT_THRESHOLD_DEFAULT =
      ScmConfigKeys.HDDS_RATIS_SNAPSHOT_THRESHOLD_DEFAULT;
  public static final String HDDS_RATIS_LEADER_FIRST_ELECTION_MINIMUM_TIMEOUT_DURATION_KEY =
      "hdds.raft.server.rpc.first-election.timeout";

  public static final String HDDS_DATANODE_PLUGINS_KEY =
      "hdds.datanode.plugins";

  public static final String
      HDDS_DATANODE_STORAGE_UTILIZATION_WARNING_THRESHOLD =
      "hdds.datanode.storage.utilization.warning.threshold";
  public static final double
      HDDS_DATANODE_STORAGE_UTILIZATION_WARNING_THRESHOLD_DEFAULT = 0.75;
  public static final String
      HDDS_DATANODE_STORAGE_UTILIZATION_CRITICAL_THRESHOLD =
      "hdds.datanode.storage.utilization.critical.threshold";
  public static final double
      HDDS_DATANODE_STORAGE_UTILIZATION_CRITICAL_THRESHOLD_DEFAULT = 0.95;

  public static final String HDDS_DATANODE_METADATA_ROCKSDB_CACHE_SIZE =
      "hdds.datanode.metadata.rocksdb.cache.size";
  public static final String
      HDDS_DATANODE_METADATA_ROCKSDB_CACHE_SIZE_DEFAULT = "1GB";

  // Specifying the dedicated volumes for per-disk db instances.
  // For container schema v3 only.
  public static final String HDDS_DATANODE_CONTAINER_DB_DIR =
      "hdds.datanode.container.db.dir";

  public static final String OZONE_SECURITY_ENABLED_KEY =
      "ozone.security.enabled";
  public static final boolean OZONE_SECURITY_ENABLED_DEFAULT = false;

  public static final String OZONE_HTTP_SECURITY_ENABLED_KEY =
      "ozone.security.http.kerberos.enabled";
  public static final boolean OZONE_HTTP_SECURITY_ENABLED_DEFAULT = false;
  public static final String OZONE_HTTP_FILTER_INITIALIZERS_KEY =
      "ozone.http.filter.initializers";

  public static final String OZONE_CONTAINER_COPY_WORKDIR =
      "hdds.datanode.replication.work.dir";

  public static final int OZONE_CLIENT_BYTES_PER_CHECKSUM_MIN_SIZE = 8 * 1024;

  public static final String OZONE_CLIENT_READ_TIMEOUT
          = "ozone.client.read.timeout";
  public static final String OZONE_CLIENT_READ_TIMEOUT_DEFAULT = "30s";
  public static final String OZONE_ACL_AUTHORIZER_CLASS =
      "ozone.acl.authorizer.class";
  public static final String OZONE_ACL_AUTHORIZER_CLASS_DEFAULT =
      "org.apache.hadoop.ozone.security.acl.OzoneAccessAuthorizer";
  public static final String OZONE_ACL_AUTHORIZER_CLASS_NATIVE =
      "org.apache.hadoop.ozone.security.acl.OzoneNativeAuthorizer";
  public static final String OZONE_ACL_ENABLED =
      "ozone.acl.enabled";
  public static final boolean OZONE_ACL_ENABLED_DEFAULT =
      false;
  public static final String OZONE_S3_VOLUME_NAME =
          "ozone.s3g.volume.name";
  public static final String OZONE_S3_VOLUME_NAME_DEFAULT =
          "s3v";

  public static final String OZONE_FS_ITERATE_BATCH_SIZE =
      "ozone.fs.iterate.batch-size";
  public static final int OZONE_FS_ITERATE_BATCH_SIZE_DEFAULT = 100;

  // Ozone Client Retry and Failover configurations
  public static final String OZONE_CLIENT_FAILOVER_MAX_ATTEMPTS_KEY =
      "ozone.client.failover.max.attempts";
  public static final int OZONE_CLIENT_FAILOVER_MAX_ATTEMPTS_DEFAULT =
      500;
  public static final String OZONE_CLIENT_WAIT_BETWEEN_RETRIES_MILLIS_KEY =
      "ozone.client.wait.between.retries.millis";
  public static final long OZONE_CLIENT_WAIT_BETWEEN_RETRIES_MILLIS_DEFAULT =
      2000;

  public static final String OZONE_FREON_HTTP_ENABLED_KEY =
      "ozone.freon.http.enabled";
  public static final String OZONE_FREON_HTTP_BIND_HOST_KEY =
      "ozone.freon.http-bind-host";
  public static final String OZONE_FREON_HTTPS_BIND_HOST_KEY =
      "ozone.freon.https-bind-host";
  public static final String OZONE_FREON_HTTP_ADDRESS_KEY =
      "ozone.freon.http-address";
  public static final String OZONE_FREON_HTTPS_ADDRESS_KEY =
      "ozone.freon.https-address";

  public static final String OZONE_FREON_HTTP_BIND_HOST_DEFAULT = "0.0.0.0";
  public static final int OZONE_FREON_HTTP_BIND_PORT_DEFAULT = 9884;
  public static final int OZONE_FREON_HTTPS_BIND_PORT_DEFAULT = 9885;
  public static final String
      OZONE_FREON_HTTP_KERBEROS_PRINCIPAL_KEY =
      "ozone.freon.http.auth.kerberos.principal";
  public static final String
      OZONE_FREON_HTTP_KERBEROS_KEYTAB_FILE_KEY =
      "ozone.freon.http.auth.kerberos.keytab";
  public static final String OZONE_FREON_HTTP_AUTH_TYPE =
      "ozone.freon.http.auth.type";
  public static final String OZONE_FREON_HTTP_AUTH_CONFIG_PREFIX =
      "ozone.freon.http.auth.";

  public static final String OZONE_NETWORK_TOPOLOGY_AWARE_READ_KEY =
      "ozone.network.topology.aware.read";
  public static final boolean OZONE_NETWORK_TOPOLOGY_AWARE_READ_DEFAULT = true;

  public static final String OZONE_MANAGER_FAIR_LOCK = "ozone.om.lock.fair";
  public static final boolean OZONE_MANAGER_FAIR_LOCK_DEFAULT = false;

  public static final String OZONE_MANAGER_STRIPED_LOCK_SIZE_PREFIX =
      "ozone.om.lock.stripes.";

  public static final int OZONE_MANAGER_STRIPED_LOCK_SIZE_DEFAULT = 512;

  public static final String OZONE_HTTP_BASEDIR = "ozone.http.basedir";

  public static final String OZONE_HTTP_POLICY_KEY =
      "ozone.http.policy";
  public static final String OZONE_HTTP_POLICY_DEFAULT =
      HttpConfig.Policy.HTTP_ONLY.name();
  public static final String  OZONE_SERVER_HTTPS_KEYSTORE_RESOURCE_KEY =
      "ozone.https.server.keystore.resource";
  public static final String  OZONE_SERVER_HTTPS_KEYSTORE_RESOURCE_DEFAULT =
      "ssl-server.xml";
  public static final String  OZONE_SERVER_HTTPS_KEYPASSWORD_KEY =
      "ssl.server.keystore.keypassword";
  public static final String  OZONE_SERVER_HTTPS_KEYSTORE_PASSWORD_KEY =
      "ssl.server.keystore.password";
  public static final String  OZONE_SERVER_HTTPS_KEYSTORE_LOCATION_KEY =
      "ssl.server.keystore.location";
  public static final String  OZONE_SERVER_HTTPS_TRUSTSTORE_LOCATION_KEY =
      "ssl.server.truststore.location";
  public static final String OZONE_SERVER_HTTPS_TRUSTSTORE_PASSWORD_KEY =
      "ssl.server.truststore.password";
  public static final String OZONE_CLIENT_HTTPS_KEYSTORE_RESOURCE_KEY =
      "ozone.https.client.keystore.resource";
  public static final String OZONE_CLIENT_HTTPS_KEYSTORE_RESOURCE_DEFAULT =
      "ssl-client.xml";
  public static final String OZONE_CLIENT_HTTPS_NEED_AUTH_KEY =
      "ozone.https.client.need-auth";
  public static final boolean OZONE_CLIENT_HTTPS_NEED_AUTH_DEFAULT = false;

  public static final int OZONE_INIT_DEFAULT_LAYOUT_VERSION_DEFAULT = -1;
  public static final String OZONE_CLIENT_KEY_PROVIDER_CACHE_EXPIRY =
      "ozone.client.key.provider.cache.expiry";
  public static final long OZONE_CLIENT_KEY_PROVIDER_CACHE_EXPIRY_DEFAULT =
      TimeUnit.DAYS.toMillis(10); // 10 days

  public static final String OZONE_CLIENT_KEY_LATEST_VERSION_LOCATION =
      "ozone.client.key.latest.version.location";
  public static final boolean OZONE_CLIENT_KEY_LATEST_VERSION_LOCATION_DEFAULT =
      true;

  public static final String OZONE_CLIENT_SERVER_DEFAULTS_VALIDITY_PERIOD_MS =
      "ozone.client.server-defaults.validity.period.ms";

  public static final long
      OZONE_CLIENT_SERVER_DEFAULTS_VALIDITY_PERIOD_MS_DEFAULT =
      TimeUnit.HOURS.toMillis(1); // 1 hour

  public static final String OZONE_FLEXIBLE_FQDN_RESOLUTION_ENABLED =
          "ozone.network.flexible.fqdn.resolution.enabled";
  public static final boolean OZONE_FLEXIBLE_FQDN_RESOLUTION_ENABLED_DEFAULT =
          false;

  public static final String OZONE_JVM_NETWORK_ADDRESS_CACHE_ENABLED =
          "ozone.network.jvm.address.cache.enabled";
  public static final boolean OZONE_JVM_NETWORK_ADDRESS_CACHE_ENABLED_DEFAULT =
          true;

  public static final String OZONE_CLIENT_REQUIRED_OM_VERSION_MIN_KEY =
      "ozone.client.required.om.version.min";

  public static final String OZONE_CLIENT_REQUIRED_OM_VERSION_MIN_DEFAULT =
      OzoneManagerVersion.S3G_PERSISTENT_CONNECTIONS.name();

  public static final String
      OZONE_CLIENT_BUCKET_REPLICATION_CONFIG_REFRESH_PERIOD_MS =
      "ozone.client.bucket.replication.config.refresh.time.ms";
  public static final long
      OZONE_CLIENT_BUCKET_REPLICATION_CONFIG_REFRESH_PERIOD_DEFAULT_MS =
      300 * 1000;

  // Values for bucket layout configurations.
  public static final String OZONE_BUCKET_LAYOUT_LEGACY =
      "LEGACY";
  public static final String OZONE_BUCKET_LAYOUT_FILE_SYSTEM_OPTIMIZED =
      "FILE_SYSTEM_OPTIMIZED";
  public static final String OZONE_BUCKET_LAYOUT_OBJECT_STORE =
      "OBJECT_STORE";

  public static final String OZONE_CLIENT_FS_DEFAULT_BUCKET_LAYOUT =
      "ozone.client.fs.default.bucket.layout";
  public static final String OZONE_CLIENT_FS_BUCKET_LAYOUT_DEFAULT =
      OZONE_BUCKET_LAYOUT_FILE_SYSTEM_OPTIMIZED;

  public static final String OZONE_S3G_DEFAULT_BUCKET_LAYOUT_KEY =
      "ozone.s3g.default.bucket.layout";
  public static final String OZONE_S3G_DEFAULT_BUCKET_LAYOUT_DEFAULT =
      OZONE_BUCKET_LAYOUT_OBJECT_STORE;

  public static final String OZONE_AUDIT_LOG_DEBUG_CMD_LIST_OMAUDIT =
      "ozone.audit.log.debug.cmd.list.omaudit";

  // Items listing page size for fs client sub-commands output
  public static final String
      OZONE_FS_LISTING_PAGE_SIZE = "ozone.fs.listing.page.size";

  public static final int
      OZONE_FS_LISTING_PAGE_SIZE_DEFAULT = 1024;

  public static final int
      OZONE_FS_MAX_LISTING_PAGE_SIZE = 5000;

  public static final String
      OZONE_FS_LISTING_PAGE_SIZE_MAX = "ozone.fs.listing.page.size.max";

  public static final String FS_TRASH_CLASSNAME = "fs.trash.classname";
  public static final String FS_TRASH_CLASSNAME_DEFAULT =
      "org.apache.hadoop.fs.ozone.OzoneTrashPolicy";

  public static final String
      OZONE_OM_SNAPSHOT_COMPACTION_DAG_MAX_TIME_ALLOWED =
      "ozone.om.snapshot.compaction.dag.max.time.allowed";

  public static final long
      OZONE_OM_SNAPSHOT_COMPACTION_DAG_MAX_TIME_ALLOWED_DEFAULT =
      TimeUnit.DAYS.toMillis(30);

  public static final String
      OZONE_OM_SNAPSHOT_COMPACTION_DAG_PRUNE_DAEMON_RUN_INTERVAL =
      "ozone.om.snapshot.compaction.dag.prune.daemon.run.interval";

  public static final long
      OZONE_OM_SNAPSHOT_PRUNE_COMPACTION_DAG_DAEMON_RUN_INTERVAL_DEFAULT =
      TimeUnit.HOURS.toMillis(1);

  public static final String
      OZONE_OM_SNAPSHOT_PRUNE_COMPACTION_BACKUP_BATCH_SIZE =
      "ozone.om.snapshot.prune.compaction.backup.batch.size";

  public static final int
      OZONE_OM_SNAPSHOT_PRUNE_COMPACTION_BACKUP_BATCH_SIZE_DEFAULT = 2000;

  public static final String OZONE_OM_SNAPSHOT_LOAD_NATIVE_LIB =
      "ozone.om.snapshot.load.native.lib";
  public static final boolean OZONE_OM_SNAPSHOT_LOAD_NATIVE_LIB_DEFAULT = true;

  public static final String OZONE_OM_DELTA_UPDATE_DATA_SIZE_MAX_LIMIT =
      "ozone.om.delta.update.data.size.max.limit";
  public static final String
      OZONE_OM_DELTA_UPDATE_DATA_SIZE_MAX_LIMIT_DEFAULT = "1024MB";

  public static final TimeDuration
      OZONE_SCM_CLOSE_CONTAINER_WAIT_DURATION_DEFAULT =
      TimeDuration.valueOf(150, TimeUnit.SECONDS);
  public static final String OZONE_SCM_CLOSE_CONTAINER_WAIT_DURATION =
      "ozone.scm.close.container.wait.duration";

  public static final String HDDS_SCM_CLIENT_RPC_TIME_OUT =
      "hdds.scmclient.rpc.timeout";
  public static final String HDDS_SCM_CLIENT_MAX_RETRY_TIMEOUT =
      "hdds.scmclient.max.retry.timeout";
  public static final String HDDS_SCM_CLIENT_FAILOVER_MAX_RETRY =
      "hdds.scmclient.failover.max.retry";

  public static final String OZONE_XCEIVER_CLIENT_METRICS_PERCENTILES_INTERVALS_SECONDS_KEY =
      "ozone.xceiver.client.metrics.percentiles.intervals.seconds";

  public static final String
      OZONE_OM_NETWORK_TOPOLOGY_REFRESH_DURATION =
      "ozone.om.network.topology.refresh.duration";
  public static final String
      OZONE_OM_NETWORK_TOPOLOGY_REFRESH_DURATION_DEFAULT = "1h";

  public static final String OZONE_SECURITY_CRYPTO_COMPLIANCE_MODE =
      "ozone.security.crypto.compliance.mode";
  public static final String OZONE_SECURITY_CRYPTO_COMPLIANCE_MODE_UNRESTRICTED = "unrestricted";

  /**
   * There is no need to instantiate this class.
   */
  private OzoneConfigKeys() {
  }
}
