defmodule ConnectToJavaSocket.CLI do
  @default_host "localhost"
  @default_port 4444
  require Logger

  def main(argv) do
    argv
    |> parse_args
    |> process
  end

  defp parse_args(argv) do
    parse = OptionParser.parse(argv, switches: [])

    case parse do
      {_, [port, host], _} ->
        {port |> String.to_integer(), host}

      {_, [port], _} ->
        {port |> String.to_integer(), @default_host}

      _ ->
        {@default_port, @default_host}
    end
  end

  defp process({port, host}) do
    socket = Socket.TCP.connect!(host, port, packet: :line)
    Logger.info("Connected")
    log_indefinetly(socket)
  end

  defp log_indefinetly(socket) do
    socket
    |> Socket.Stream.recv!()
    |> String.trim()
    |> Logger.info()

    log_indefinetly(socket)
  end
end
