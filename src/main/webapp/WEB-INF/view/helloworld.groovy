yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
    head {
        meta('http-equiv': '"Content-Type" content="text/html; charset=utf-8"')
        title('Hello world !!!')
    }
    body {
        p("Hello world of spring !!!")
        newLine()
        p("Student name: ${model.studentName}")
        newLine()
        p("message: ${model.greeting}")
    }
}