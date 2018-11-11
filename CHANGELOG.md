# Change Log
All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

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