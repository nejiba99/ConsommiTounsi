'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;
var usersList = "";
var user={
		"id_user": "1",
	    "address_user" : "sfax",
	    "dtype" : "Client",
	    "email_user" : "said.feki@esprit.tn",
	    "first_name_user" : "said",
	    "last_name_user" : "feki",
	    "status_client":"1"};
var userid="";

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
    //username = document.querySelector('#name').value.trim();
    username=user.first_name_user+user.last_name_user;
    userid=user.id_user;
    if(username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}


function onConnected() {
    // Subscribe to the Public Topic
    //stompClient.subscribe('/topic/public', onMessageReceived);
    stompClient.subscribe('/topic/public', onDisplay);
    // Tell your username to the server
    /*stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: user, type: 'JOIN'})
    )*/
    stompClient.send("/app/chat.getHistory",
        {},
        JSON.stringify({sender: user, type: 'JOIN'})
    )

    connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}


function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var chatMessage = {
            sender: user,
            content: messageInput.value,
            type: 'CHAT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}


function onDisplay(payload) {
    var mes = JSON.parse(payload.body);
    if( mes.length>1 && usersList!=username){
    	for (const message of mes) {
    		console.log(message);
    		var messageElement = document.createElement('li');

    	    if(message.type === 'JOIN') {
    	        messageElement.classList.add('event-message');
    	        message.content = username + ' joined!';
    	    } else if (message.type === 'LEAVE') {
    	        messageElement.classList.add('event-message');
    	        message.content = username + ' left!';
    	    } else {
    	        messageElement.classList.add('chat-message');

    	        var avatarElement = document.createElement('i');
    	        var avatarText = document.createTextNode(username[0]);
    	        avatarElement.appendChild(avatarText);
    	        avatarElement.style['background-color'] = getAvatarColor(username);

    	        messageElement.appendChild(avatarElement);

    	        var usernameElement = document.createElement('span');
    	        var usernameText = document.createTextNode(username);
    	        
    	        usernameElement.appendChild(usernameText);
    	        messageElement.appendChild(usernameElement);
    	        var dateTest=convert(message.date);
    	        var date =document.createTextNode(dateTest);
    	        messageElement.appendChild(date);
    	    }

    	    var textElement = document.createElement('p');
    	    var messageText = document.createTextNode(message.content);
    	    textElement.appendChild(messageText);
    	   
    	    messageElement.appendChild(textElement);
    
    	    messageArea.appendChild(messageElement);
    	    messageArea.scrollTop = messageArea.scrollHeight;
    	    
    		}
    	usersList=username;

    }
    else {
    	var message = mes;
    	 var messageElement = document.createElement('li');

    	    if(message.type === 'JOIN') {
    	        messageElement.classList.add('event-message');
    	        message.content = username + ' joined!';
    	    } else if (message.type === 'LEAVE') {
    	        messageElement.classList.add('event-message');
    	        message.content = username + ' left!';
    	    } else {
    	        messageElement.classList.add('chat-message');

    	        var avatarElement = document.createElement('i');
    	        var avatarText = document.createTextNode(username[0]);
    	        avatarElement.appendChild(avatarText);
    	        avatarElement.style['background-color'] = getAvatarColor(username);

    	        messageElement.appendChild(avatarElement);

    	        var usernameElement = document.createElement('span');
    	        var usernameText = document.createTextNode(username);
    	        usernameElement.appendChild(usernameText);
    	        messageElement.appendChild(usernameElement);
    	        var dateTest=convert(message.date);
    	        var date =document.createTextNode(dateTest);
    	        messageElement.appendChild(date);
    	    }

    	    var textElement = document.createElement('p');
    	    var messageText = document.createTextNode(message.content);
    	    textElement.appendChild(messageText);
    	   
    	   
    	    messageElement.appendChild(textElement);
    
    
    	    messageArea.appendChild(messageElement);
    	    messageArea.scrollTop = messageArea.scrollHeight;
    }   
}

function onMessageReceived(payload) {
    var mes= JSON.parse(payload.body);
    console.log(message);
    var messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = username + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = username + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(username[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(username);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(username);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
        var dateTest="   "+message.date.toString();
        var date =document.createTextNode(dateTest);
        messageElement.appendChild(date);
    }

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}

function convert(date){
	  var datearray = date.split("T");
	  var dateres= datearray[0].split("-")
	  var timearray= datearray[1].split(".");
	  var newdate="   "+dateres[2]+"/"+dateres[1]+"/"+dateres[0]+"  "+timearray[0]; 
	  return newdate;
	}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)