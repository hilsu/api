# Hil API

Библиотека для удобной отправки запросов.

### Основное

Все крутится вокруг экземпляра класса NetClient. Его конструктор принимает токен авторизации для выполнения запросов.

### Отправка и обработка запросов
Собственно, выполнить запрос можно с помощью метода `runRequest()`
Метод принимает объект реквеста, а возвращает CompletableFuture с типом ответа.

Обработать фьючер можно с помощью назначения метода и пула (Executor) обработки. Делается это методом `whenCompleteAsync()`. Метод-обработчик должен принимать в аргументах объект ответа и Throwable.

#### Пример:
        void sendVoid() {
            client.runRequest(new EconomyAPI.TransactionRequest("pawka", new BigDecimal(-1)))
		.whenCompleteAsync(this::handleResponse, executor);
        }
    
        void handleResponse(EconomyAPI.TransactionResponse response, Throwable e) {
            if (e == null) {
                System.out.println("Успешная отправка!");
                return;
            }
    
            // В данном случае, к несчастью, отправить отрицательно значение червонцев мы не можем, поэтому нам придется обработать ошибку.
            if (e instanceof InvalidAmountAPIException) {
                System.out.println("Неправильная сумма!");
            }else {
                // Другая ошибка
            }
        }

### Существующие запросы & ответы
- EconomyAPI
  - Balance
  - Transaction
  - Changes
  - Transfers
 
### Собственный запрос & ответ

Запрос должен реализовывать интерфейс `IRequestAPI` с типом ответа.

Класс ответа должен содержать поля индентичные с полями структуры json. Gson автоматически сует данные в переменные. Конструктор должен быть дефолтным.

#### Пример:
        public static class TransfersRequest implements IRequestAPI<TransfersResponse> {
            protected Currency currency;
            protected int limit;
            protected int offset;
    
            public TransfersRequest(Currency currency, int limit, int offset) {
                this.currency = currency;
                this.limit = limit;
                this.offset = offset;
            }
    
            @Override
            public Class<TransfersResponse> getResponseClass() {
                return TransfersResponse.class;
            }
    
            @Override
            public String getUrl() {
                return Misc.formatQueryURL("economy/transfers", "limit", limit, "offset", offset);
            }
    
            @Override
            public RequestMethod getMethod() {
                return RequestMethod.GET;
            }
    
            @Override
            public Object getData() {
                return null;
            }
        }
    
        public static class TransfersResponse {
            UUID userId;
            String username;
            TransferLog[] transfers;
    
            public UUID getUserId() {
                return userId;
            }
    
            public String getUsername() {
                return username;
            }
    
            public TransferLog[] getTransfers() {
                return transfers;
            }
        }