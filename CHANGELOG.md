# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

# unreleased

# 0.6.2

Internal changes to version management

# 0.6.1

Lib version bump

- [flyway](https://github.com/flyway/flyway/releases) `7.12.0` ->  `10.12.0`
- [cats-effect](https://github.com/typelevel/cats-effect/releases) `3.2.1` -> `3.5.4`

# 0.6.0

This is the first release that is also available for cats-effect 3 and Scala 3!

### :warning: breaking changes
- `pureharm-db-flyway` now depends on cats-effect 3! If you are still on cats-effect 2 then use `pureharm-db-flyway-ce2`
- remove dependency on `pureharm-config`, depend on it in user code, or on `pureharm-config-ciris`, and use it there to read the config.

### dependency upgrades

- [flyway](https://github.com/flyway/flyway/releases) `7.12.0`
- [cats-effect](https://github.com/typelevel/cats-effect/releases) `3.2.1` / `2.5.2`
- [pureharm-core](https://github.com/busymachines/pureharm-core/releases) `0.3.0`
- [pureharm-db-core](https://github.com/busymachines/pureharm-db-core/releases) `0.5.0`
- [pureharm-db-core-jdbc](https://github.com/busymachines/pureharm-db-core-jdbc/releases) `0.5.0`

### internals
- bump scalafmt to `3.0.0-RC6` — from `2.7.5`
- bump sbt to `1.5.5`
- bump sbt-spiewak to `0.21.0`
- bump sbt-scalafmt to `2.4.3`

# 0.5.0

Identical to `0.6.0` for Scala 2, but unfortunately it was not released for Scala 3 due to botched release.

# 0.4.0

:warning: This is the last release that depends on [pureharm-config](https://github.com/busymachines/pureharm-config/releases). Please move config reading into user-code, you can easily do this by depending directly on [pureharm-config](https://github.com/busymachines/pureharm-config/releases), for source and config compat with existing code. Ideally migrate to [pureharm-config-ciris](https://github.com/busymachines/pureharm-config-ciris) instead.

### dependency upgrades

- [pureharm-config](https://github.com/busymachines/pureharm-config/releases) `0.4.0` - will be removed in a future version
- [pureharm-db-core](https://github.com/busymachines/pureharm-db-core/releases) `0.4.0`
- [pureharm-db-core-jdbc](https://github.com/busymachines/pureharm-db-core-jdbc/releases) `0.4.0`

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
