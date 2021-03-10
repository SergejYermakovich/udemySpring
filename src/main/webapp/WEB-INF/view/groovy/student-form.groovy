yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en') {
    head {
        meta('http-equiv': '"Content-Type" content="text/html; charset=utf-8"')
        title('My page')
    }
    body {
        form(action: 'processStudentForm', modelAttribute: ${student}) {
            input(name: 'firstName', type: 'text', placeholder: 'What s your firstName?')
            input(name: 'lastName', type: 'text', placeholder: 'What s your lastName?')
            input(type: 'submit', value: 'Submit query')
        }
    }
}