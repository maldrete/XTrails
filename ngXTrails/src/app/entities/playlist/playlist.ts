import { User } from '../user/user';
import { TransitiveCompileNgModuleMetadata } from '@angular/compiler';

export class Playlist {
  id: number;
  name: string;
  description: string;
  hashtags: string;
  trails: trail;
  user: User;

  constructor(
    id?: number,
    name?: string,
    description?: string,
    hashtags?: string,
    trails?: trail,
    user?: User
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.hashtags = hashtags;
    this.trails = trails;
    this.user = user;
  }

}
