1.4.0 [(Link to github)](https://github.com/iSnow/xcelite/releases/tag/v1.4.0)
=====================================
- Xcelite can now read the old Excel '97 file format

1.3.0 [(Link to github)](https://github.com/iSnow/xcelite/releases/tag/v1.3.0)
=====================================
- Added `anyColumnCreatesCollection` option to allow `@AnyColum` to switch between two behaviors (for
 `BeanSheetReaders` only) if an Excel sheet contains more than one column with the same column name:
  - false (default for versions <2.0): like in previous versions, only the last column value is returned, 
  ie. if your sheet has three columns named "project name" that are part of an `@AnyColum` set, only the value 
  of the last (right-most) column will be returned
  - true: (default for version 2.0 and up): all column values in `@AnyColum` sets are returned as `Collection`s, 
  so that no data is lost
- Big refactoring of SheetReader and SheetWriter subclasses to use common code bases
- Some additional tests, esp. for Writers

1.2.5 [(Link to github)](https://github.com/iSnow/xcelite/releases/tag/v1.2.5)
=====================================
- Added `optional` parameter to @Column annotation to denote columns that might or might not be present. If a 
column is annotated as `optional` and it is missing, their value will be `null`, but no exception will be thrown. 
- Updated dependencies.


1.2.3 [(Link to github)](https://github.com/iSnow/xcelite/releases/tag/v1.2.3)
=====================================
- All configuration of Xcelite, XceliteSheet and Readers/Writers is now done through a XceliteOptions object
- Behavior of Readers/Writers when encountering null/empty rows and columns can be configured via policies.
- More fine-grained exceptions
- Deprecation notice for some methods what will go away in Xcelite 2.x
- Created a lot of tests for Writers/Readers.
- Dependencies: migrated to [Apache POI 4.0.x](https://poi.apache.org/), commons-collections 4.x
- Java version is now set to 8, 
matching the [requirements of POI](http://www.apache.org/dist/poi/release/RELEASE-NOTES.txt).

1.1.0 [(Link to github)](https://github.com/iSnow/xcelite/releases/tag/v1.1.0)
=====================================
- fixed header parsing for sheets with cells being null in header column 
- fixed some exceptions due to Error cells
- Resolved some POI deprecations 
- Updated dependencies and integrated a couple pull requests to the abandoned eBay-repo to carry the project on.
- Java version is now set to 8 (might still compile for 6)
- Added ProjectLombok as dependency to replace the try/catch blocks that convert checked exceptions to 
runtime-exceptions with the @sneakythrows annotation from Lombok.

