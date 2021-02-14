const messageApi = Vue.resource('/users{/id}');

Vue.component('message-row', {
    props: ['message'],
    template: '<div><i>({{message.id}})</i>{{message.name}} </div>'
});

Vue.component('menu-item', {
    props: ['messages'],
    template:
        '<div> ' +
        '<message-row v-for = "message in messages" :key = "message.id" :message = "message"/>' +
        '</div>',
    created: function () {
        messageApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => this.messages.push(message))
            )
        )
    }
});

const app = new Vue({
    el: '#app',
    template: '<menu-item :messages="messages" />',
    data: {
        messages: [
            // {id: '1', text: 'Главная'},
            // {id: '2', text: 'Стройки'},
            // {id: '3', text: 'Пользователи'}
        ]
    }
});