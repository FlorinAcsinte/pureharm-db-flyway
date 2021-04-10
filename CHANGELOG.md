# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

# unreleased

### dependency upgrades

- [pureharm-config](https://github.com/busymachines/pureharm-config/releases) `0.4.0` - will be removed in a future version

# 0.3.0

### dependency upgrades

- [flyway](https://github.com/flyway/flyway/releases) `7.7.3`
- [pureharm-config](https://github.com/busymachines/pureharm-config/releases) `0.3.0` - will be removed in a future version
- [pureharm-db-core](https://github.com/busymachines/pureharm-db-core/releases) `0.3.0`
- [pureharm-db-core-jdbc](https://github.com/busymachines/pureharm-db-core-jdbc/releases) `0.3.0`

# 0.2.0

### dependency upgrades

- [flyway](https://github.com/flyway/flyway/releases) `7.7.2`
- [pureharm-core-anomaly](https://github.com/busymachines/pureharm-core/releases) `0.2.0`
- [pureharm-core-sprout](https://github.com/busymachines/pureharm-core/releases) `0.2.0`
- [pureharm-config](https://github.com/busymachines/pureharm-config/releases) `0.2.0` - will be removed in a future version
- [pureharm-db-core](https://github.com/busymachines/pureharm-db-core/releases) `0.2.0`
- [pureharm-db-core-jdbc](https://github.com/busymachines/pureharm-db-core-jdbc/releases) `0.2.0`

# 0.1.0

Split out from [pureharm](https://github.com/busymachines/pureharm) as of version `0.0.7`.

:warning: Breaking changes :warning:

- renamed module maven artifact ID from `pureharm-db-core-flyway` to `pureharm-db-flyway`

- cross compiled to Scala 2.13 -- pending support for scala 3.0.0-RC1
- add `Option[FlywayConfig]` object to `Flyway.clean` method w/ default `Option.empty`, thus making this a source compatible change.

Deprecations:

- deprecate `Flyway` methods that take JDBCUrl in favor of methods that take `DBConnectionConfig`.
