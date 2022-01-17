# ConnectToJavaSocket

Little command-line app that connects to a socket and logs all incoming messages.

## Compilation

To compile the program it's required to have [Elixir](https://elixir-lang.org/install.html) installed. The installation of Elixir includes `mix`, the Elixir build tool.

Go to the folder where you copied the source code and run:

```
mix escript.build
```

This will generate an executable file called `connect_to_java_socket`, without extension.

## Execution

The executable file can accept two optional arguments: The port and the host.

```
./connect_to_java_socket [<port> [<host>]]
```

For example:

```
./connect_to_java_socket 4444 localhost
```

The default port value is `4444`, and the default host is `localhost`. So, the previous command is equal to:

```
./connect_to_java_socket
```

## How does the program works?

It's very simple. The entry point is in the file `connect_to_java_socket/cli.ex`. The `parse` step takes the input of the user and returns a touple containing the port and the host. If a field is missing, it uses the default value. Then the `process` step receives the touple and connects a TCP Socket to the given host and port. Then it waits for an incoming message, trims it, logs it and waits again.
