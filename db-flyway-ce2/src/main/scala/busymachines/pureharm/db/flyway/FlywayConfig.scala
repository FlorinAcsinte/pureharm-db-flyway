/*
 * Copyright 2019 BusyMachines
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package busymachines.pureharm.db.flyway

import busymachines.pureharm.db.SchemaName

/** @author
  *   Lorand Szakacs, https://github.com/lorandszakacs
  * @since 30
  *   Jul 2019
  * -- Currently does not support all possible flyway configurations, any new supported ones will be added with the same
  * default values as Flyway uses to make all changes source-compatible.
  * --
  * @param schemas
  *   the schemas managed by flyway. If empty defaults to "public".
  *
  * Seeorg.flywaydb.core.api.configuration.FluentConfiguration#schemas for details, this is just a simple wrapper
  * @param migrationLocations
  *   the locations at which to find migrations,
  *
  * if the list is empty then it defaults to `/db/migration` folder on the classpath. If you use the given config
  * reader, then you can completely omit the given field, and it will be interpreted as an empty list, i.e. it will use
  * default
  *
  * See org.flywaydb.core.api.configuration.FluentConfiguration#locations for details, this is just a simple wrapper
  * @param ignoreMissingMigrations
  *   See org.flywaydb.core.api.configuration.FluentConfiguration#ignoreMissingMigrations
  * @param cleanOnValidationError
  *   NEVER SET THIS TO TRUE IN PROD. This is useful only for development, it will clean the DB if there's a validation
  *   error in the schema (i.e. assumed to be because of in place modification of a migration in a rapidly moving
  *   environment) See org.flywaydb.core.api.configuration.FluentConfiguration#cleanOnValidationError()
  */
final case class FlywayConfig(
  schemas:                 List[SchemaName]        = List.empty,
  migrationLocations:      List[MigrationLocation] = List.empty,
  ignoreMissingMigrations: IgnoreMissingMigrations = IgnoreMissingMigrations.False,
  cleanOnValidationError:  CleanOnValidationError  = CleanOnValidationError.False,
) extends internals.FlywayConfigFluentApi {

  override def withLocations(locations: MigrationLocation*): FlywayConfig = this.withLocations(locations.toList)

  override def withLocations(locations: List[MigrationLocation]): FlywayConfig =
    this.copy(migrationLocations = locations)

  override def withSchemas(schemas:     SchemaName*):             FlywayConfig = this.withSchemas(schemas.toList)
  override def withSchemas(schemas:     List[SchemaName]):        FlywayConfig = this.copy(schemas = schemas)

  override def withIgnoreMissingMigrations(ignore: IgnoreMissingMigrations): FlywayConfig =
    this.copy(ignoreMissingMigrations = ignore)

  override def withCleanOnValidationErrors(clean:  CleanOnValidationError):  FlywayConfig =
    this.copy(cleanOnValidationError = clean)

  override def defaultConfig: FlywayConfig = FlywayConfig()
}

object FlywayConfig extends internals.FlywayConfigFluentApi {

  override def defaultConfig: FlywayConfig = FlywayConfig()

  override def withLocations(locations: MigrationLocation*):      FlywayConfig =
    FlywayConfig(migrationLocations = locations.toList)

  override def withLocations(locations: List[MigrationLocation]): FlywayConfig =
    FlywayConfig(migrationLocations = locations)

  override def withSchemas(schemas:     SchemaName*):             FlywayConfig = FlywayConfig(schemas = schemas.toList)
  override def withSchemas(schemas:     List[SchemaName]):        FlywayConfig = FlywayConfig(schemas = schemas)

  override def withIgnoreMissingMigrations(ignore: IgnoreMissingMigrations): FlywayConfig =
    FlywayConfig(ignoreMissingMigrations = ignore)

  override def withCleanOnValidationErrors(clean:  CleanOnValidationError):  FlywayConfig =
    FlywayConfig(cleanOnValidationError = clean)
}
