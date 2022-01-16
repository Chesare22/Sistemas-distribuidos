defmodule ConnectToJavaSocket.CLI do
  @default_host "localhost"
  @default_port 4444
  require Logger

  def run(argv) do
    argv
    |> parse_args
    |> process
  end

  defp parse_args(argv) do
    parse = OptionParser.parse(argv, switches: [])

    case parse do
      {_, [port, host], _} ->
        [port, host]

      {_, [port], _} ->
        [port, @default_host]

      _ ->
        [@default_port, @default_host]
    end
  end

  defp process([port, host]) do
    sock = Socket.TCP.connect!(host, port, packet: :line)
    Logger.info("Connected")
    log_indefinetly(sock)
  end

  defp log_indefinetly(socket) do
    socket
    |> Socket.Stream.recv!()
    |> Logger.info()

    log_indefinetly(socket)
  end
end
