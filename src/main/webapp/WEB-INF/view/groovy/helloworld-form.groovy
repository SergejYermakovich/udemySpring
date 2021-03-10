yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
    head {
        meta('http-equiv': '"Content-Type" content="text/html; charset=utf-8"')
        title('Hello world input form !!!')
    }
    body {
        form(action: 'hello/processForm_v3', method: 'get') {
            input(name: 'studentName', type: 'text', placeholder: 'What s your name?')
            input(type: 'submit', value: 'Submit query')
        }
    }
}