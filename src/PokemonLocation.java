public class PokemonLocation extends Location{
    private Pokemon pokemon;

    public PokemonLocation(int x, int y, String description, Pokemon pokemon) {
        super(x, y, description);
        this.pokemon = pokemon;
    }
}
