## CSS

### Formatting

* Use soft tabs (2 spaces) for indentation
* Prefer dashes over camelCasing in class names.
* Do not use ID selectors
* When using multiple selectors in a rule declaration, give each selector its own line.
* Put blank lines between rule declarations

**Bad**

```css
.content-block{
    border-radius:50%;
    border:2px solid white; }
.why, .on, .same, line {
    // ...
}
#lol-no {
  // ...
}
```

**Good**

```css
.content-block {
  border-radius: 50%;
  border: 2px solid white;
}

.one,
.selector,
.per-line {
  // ...
}
```

### Comments

* Prefer comments on their own line. Avoid end-of-line comments.
* Write detailed comments for any compatibility or browser-specific workarounds/hacks

### BEM and OOCS

We encourage a combination of BEM and OOCS for these reasons:

  * It helps create clear, strict relationships between CSS and HTML
  * It allows for lower specificity and greater scalability
  * It helps us create reusable, composable components
  * It allows for less nesting, which can reduce the size of CSS file

**BEM**, or “Block-Element-Modifier”, is a _naming convention_ for classes in HTML and CSS.

  * CSS Trick's [BEM 101](https://css-tricks.com/bem-101/)

**OOCSS**, or “Object Oriented CSS”, is an approach for writing CSS that encourages you to think about your stylesheets as a collection of “objects”: reusable, repeatable snippets that can be used independently throughout a website.

  * Smashing Magazine's [Introduction to OOCSS](http://www.smashingmagazine.com/2011/12/12/an-introduction-to-object-oriented-css-oocss/)

**Example**
```css
/* ListingCard.css */
.social-feed { }
.social-feed__image { }
.social-feed--instagram { }
```

  * `.social-feed` is the “block” and represents the higher-level component
  * `.social-feed__image` is an “element” and represents a descendant of block `.social-feed`. It cannot be used outside the block.
  * `.ListingCard--instagram` is a “modifier” and represents a different state or variation on the `.social-feed` block.



### ID selectors

Using ID selectors in CSS is discouraged as it introduces an unnecessarily high level of [specificity](https://developer.mozilla.org/en-US/docs/Web/CSS/Specificity) to your rule declarations, and they are not reusable.
  

### JavaScript hooks

Avoid binding to the same class in both your CSS and JavaScript to maintain a separation of concerns.

We recommend creating JavaScript-specific classes to bind to, prefixed with `.js-`:  

```html
<button class="btn btn-primary js-request-to-book">Request to Book</button>
```

### JavaScript State Classes

JavaScript classes that represent state such as `is-active` or `is-disabled` may be assigned to elements. They do not need to follow the BEM modifier convention and can be re-used between components.  

### Border

Use `0` instead of `none` to specify that a style has no border.

**Bad**

```css
.foo {
  border: none;
}
```

**Good**

```css
.foo {
  border: 0;
}
```

## Sass

### Syntax

* Use the `.scss` syntax, never the original `.sass` syntax
* Order your regular CSS and `@include` declarations logically (see below)

### Ordering of property declarations

1. Property declarations

    List all standard property declarations, anything that isn't an `@include` or a nested selector.

    ```scss
    .btn-green {
      background: green;
      font-weight: bold;
      // ...
    }
    ```

    Grouping `@include`s at the end makes it easier to read the entire selector.

    ```scss
    .btn-green {
      background: green;
      font-weight: bold;
      @include transition(background 0.5s ease);
      // ...
    }
    ```

3. Nested selectors

    Nested selectors, _if necessary_, go last, and nothing goes after them. Add whitespace between your rule declarations and nested selectors, as well as between adjacent nested selectors. Apply the same guidelines as above to your nested selectors.

    ```scss
    .content-block {
      background: green;
      font-weight: bold;
      @include transition(background 0.5s ease);

      .icon {
        margin-right: 10px;
      }
    }
    ```

### Variables

Prefer dash-cased variable names (e.g. `$my-variable`) over camelCased or snake_cased variable names. It is acceptable to prefix variable names that are intended to be used only within the same file with an underscore (e.g. `$_my-variable`).

### Mixins

Mixins should be used to DRY up your code, add clarity, or abstract complexity--in much the same way as well-named functions. Mixins that accept no arguments can be useful for this, but note that if you are not compressing your payload (e.g. gzip), this may contribute to unnecessary code duplication in the resulting styles.

### Extend directive

`@extend` should be avoided because it has unintuitive and potentially dangerous behavior, especially when used with nested selectors. Even extending top-level placeholder selectors can cause problems if the order of selectors ends up changing later (e.g. if they are in other files and the order the files are loaded shifts). Gzipping should handle most of the savings you would have gained by using `@extend`, and you can DRY up your stylesheets nicely with mixins.

