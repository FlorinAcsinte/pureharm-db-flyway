# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

# unreleased

Split out from [pureharm](https://github.com/busymachines/pureharm) as of version `0.0.7`.

:warning: Breaking changes :warning:
- renamed module maven artifact ID from `pureharm-db-core-flyway` to `pureharm-db-flyway`

- cross compiled to Scala 2.13 -- pending support for scala 3.0.0-RC1
- add `Option[FlywayConfig]` object to `Flyway.clean` method w/ default `Option.empty`, thus making this a source compatible change.

Deprecations:
- deprecate `Flyway` methods that take JDBCUrl in favor of methods that take `DBConnectionConfig`.

# 0.1.0
