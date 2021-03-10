yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
    head {
        meta('http-equiv': '"Content-Type" content="text/html; charset=utf-8"')
        title('My page')
    }
    body {
        img(src: "resources/images/spring.png")
        p("Hello !!!")
        newLine()
        a(href: 'showForm', "Hello world form")
    }
}