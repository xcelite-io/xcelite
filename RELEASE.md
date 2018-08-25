1.2.2 [(Link to github)](https://github.com/xcelite-io/xcelite/releases/tag/v1.2.2)
=====================================
- Added unit-tests
- configuration of xcelite behavior now through XceliteOptions
- Updated dependencies and merged changes from https://github.com/VasilievAleksey/xcelite.
- Java version is now set to 8 (will no longer compile for 6)


1.1.0 [(Link to github)](https://github.com/iSnow/xcelite/releases/tag/v1.1.0)
=====================================
- fixed header parsing for sheets with cells being null in header column 
- fixed some exceptions due to Error cells
- Resolved some POI deprecations 
- Updated dependencies and integrated a couple pull requests to the abandoned eBay-repo to carry the project on.
- Java version is now set to 8 (might still compile for 6)
- Added ProjectLombok as dependency to replace the try/catch blocks that convert checked exceptions to runtime-exceptions with the @sneakythrows annotation from Lombok.

