# frontend
## Dependencies
- Vuex
  - State management
- Vue-router
  - Running in history mode, which needs configuration once deployed so routing is handled correct, see [Vue history mode](https://router.vuejs.org/guide/essentials/history-mode.html).
- Babel
  - Enables recompilation of javascript to older ECMA script standard, which makes so we can use the latest functions if we want
- Eslint + standard config
  - Basic linting so far, does not lint html templates in .vue 
  - Should lint on save, but before commit run to be sure
    ```
    npm run lint
    ```
- Bootstrap-vue
  - With icon support
- Jest
## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Run unit tests
```
npm run test:unit
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
