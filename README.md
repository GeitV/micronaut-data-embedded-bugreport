## Bug Report

This bug report is about issue with Micronaut 4.8.2 and upwards. When `@MappedEntity` has `@Relation(Embedded)` (or
`@Embedded`) element
in it which
has `@Relation` to another table, the saving of the relation is not possible anymore since 4.8.3. Run tests in this repo
to see the problem.

### Success scenario

go to [gradle.properties](gradle.properties) and set `micronautVersion=4.8.2`.

### Failure scenario

go to [gradle.properties](gradle.properties) and set `micronautVersion=4.8.3` or any newer version (eg. `4.9.0`).
