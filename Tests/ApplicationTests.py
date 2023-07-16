import requests
import json
BASE_URL = 'http://localhost:8080'


def test_home_page():
        response = requests.get(BASE_URL)
        assert response.status_code == 200
        assert response.text == "Home Page"


def test_get_logs():
        response = requests.get(BASE_URL + "/logs")
        logs = response.json()
        expected_logs = json.dumps(logs, separators=(
                ',', ':'))  # Converting the json to string

        assert response.status_code == 200
        assert response.text == expected_logs


def test_transaction():
        response = requests.get(BASE_URL + "/transaction")
        assert response.status_code == 200
        assert response.text == "You Just Created a Transactions"

