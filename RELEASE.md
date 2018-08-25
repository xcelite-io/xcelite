1.1.0 [(Link to github)](https://github.com/iSnow/xcelite/releases/tag/v1.1.0)
=====================================
- fixed header parsing for sheets with cells being null in header column 
- fixed some exceptions due to Error cells
- Resolved some POI deprecations 
- Updated dependencies and integrated a couple pull requests to the abandoned eBay-repo to carry the project on.
- Java version is now set to 8 (might still compile for 6)
- Added ProjectLombok as dependency to replace the try/catch blocks that convert checked exceptions to runtime-exceptions with the @sneakythrows annotation from Lombok.

