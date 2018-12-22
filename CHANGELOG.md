# Change Log
All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

## "0.1.0-alpha4.2" - 2018-12-22
- Fixed bug with advanced compilation doesn't accept `assert`

## "0.1.0-alpha4.2" - 2018-12-01
- Fixed bug for multiple children/node not rendered.

## "0.1.0-alpha4.1" - 2018-11-30
### Removed
- Remove `cammelCase` for component and icon declaration.

### Added
- Add `kebab-case` support for component and icon declaration.

## "0.1.0-alpha4" - 2018-11-25
### Fixed
- Readme example

### Added
- default `theme` and `with-style` function. `class-name` funtion helper.

## "0.1.0-alpha3" - 2018-11-19
### Removed
- Remove `fulcro` dependency, `id.nadiar.cljs-mui.fulcro.components`, and `id.nadiar.cljs-mui.fulcro.icons`.

### Added
- Add `fulcro` example on README.md

## "0.1.0-alpha2a" - 2018-11-11
### Removed 
- Remove `cljsjs/react`, user must add manually to prevent two different react in same project. 

### Fixed
- Fixed `id.nadiar.cljs-mui.utils/component-factory` can't receive `nil` props.
- Fixed `id.nadiar.cljs-mui.fulcro.icons`.
- Exclude `List` from cljs.core at `id.nadiar.cljs-mui.fulcro.components`.

## "0.1.0-alpha2" - 2018-11-10
### Added
- Support fulcro components & icons via `id.nadiar.cljs-mui.fulcro.components` and `id.nadiar.cljs-mui.fulcro.icons`.